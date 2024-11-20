package com.hf.springbootinit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.hf.springbootinit.common.ErrorCode;
import com.hf.springbootinit.constant.CommonConstant;
import com.hf.springbootinit.exception.BusinessException;
import com.hf.springbootinit.exception.ThrowUtils;
import com.hf.springbootinit.mapper.EchartMapper;
import com.hf.springbootinit.model.dto.post.EchartUserRequest;
import com.hf.springbootinit.model.entity.EchartParam;
import com.hf.springbootinit.model.vo.HeartDataCountVO;
import com.hf.springbootinit.service.EchartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class EchartServiceImpl extends ServiceImpl<EchartMapper, EchartParam> implements EchartService {

    @Resource
    private Jedis jedis;

    @Resource
    private EchartMapper echartMapper;


    @Override
    public void currentUser(EchartUserRequest echartUser) {

    }

    @Override
    public List<Integer> sufHealCount() {
        List<Integer> list = new ArrayList<>();
        Integer sufferCount, healthCount;
        if (Integer.valueOf(jedis.get(CommonConstant.SUFFER)) != 0 &&
                Integer.valueOf(jedis.get(CommonConstant.HEALTH))!=0 &&
            jedis.get(CommonConstant.SUFFER) != null &&
            jedis.get(CommonConstant.SUFFER) != null){
//            System.out.println("Redis逻辑");
            sufferCount = Integer.valueOf(jedis.get(CommonConstant.SUFFER));
            healthCount = Integer.valueOf(jedis.get(CommonConstant.HEALTH));
        }else {
            Map<String, BigDecimal> healCountmap = echartMapper.sufHealCount();

            BigDecimal totalNo = healCountmap.get("total_no");
            BigDecimal totalYes = healCountmap.get("total_yes");

            healthCount = totalNo.intValue();
            sufferCount = totalYes.intValue();

            jedis.set(CommonConstant.HEALTH, String.valueOf(healthCount));
            jedis.set(CommonConstant.SUFFER, String.valueOf(sufferCount));
        }
        list.add(sufferCount);
        list.add(healthCount);
        return list;
    }

    @Override
    public List<EchartParam> searchUser(EchartParam echartParam) {
        return null;
    }

    @Override
    public QueryWrapper<EchartParam> userList(EchartParam echartParam) {
        return null;
    }

    @Override
    public List<EchartParam> userInfo() {
        List<EchartParam> userinfoList = null;
        List<String> jsonString = jedis.lrange("USERINFO", -1, -20);
        // 创建 Gson 对象
        Gson gson = new Gson();
        // JSON 字符串转 Java 对象
        for (String jsonStr: jsonString){
            userinfoList.add(gson.fromJson(jsonStr, EchartParam.class));
        }
        if (StringUtils.isBlank((CharSequence) userinfoList)) {
            userinfoList = echartMapper.userInfo();
            for (EchartParam userInfo: userinfoList) {
                String userInfoStr = userInfo.toString();
                jedis.lpush("USERINFO", userInfoStr);
            }
        }
        return userinfoList;
    }

    @Override
    public String checkSingle(EchartParam echartParam) {
        /**
         * 调用第三方服务
         */
        String result = null;

        /**
         * 保存至数据库， 添加到Redis
         */
        ThrowUtils.throwIf(result == null, new BusinessException(ErrorCode.OPERATION_ERROR, "第三方服务生成失败"));
        echartParam.setHeartdisease(result);

        CompletableFuture.supplyAsync(() -> {
            echartMapper.insert(echartParam);
            return null;
        });
        String echartParamStr = echartParam.toString();
        save(echartParamStr, result);
        return result;
    }

    @Override
    public List<EchartParam> checkMul(List<String> list) {
        List<EchartParam> echartParamList = new ArrayList<>();
        for (String echartParamstr: list) {
            // 创建 Gson 实例
            Gson gson = new Gson();
            // 将 JSON 字符串转换为 Person 对象
            EchartParam echartParam = gson.fromJson(echartParamstr, EchartParam.class);
            String result = null;
            /**
             * 保存至数据库， 添加到Redis
             */
            ThrowUtils.throwIf(result == null, new BusinessException(ErrorCode.OPERATION_ERROR, "第三方服务生成失败"));
            echartParam.setHeartdisease(result);

            echartParamList.add(echartParam);

            CompletableFuture.supplyAsync(() -> {
                echartMapper.insert(echartParam);
                return null;
            });
            String echartParamStr = echartParam.toString();
            save(echartParamStr, result);
        }
        return echartParamList;
    }

    private void save(String echartParamStr, String result){
        if ("yes".equalsIgnoreCase(result)){
            jedis.incr(CommonConstant.HEALTH);
        }
        jedis.incr(CommonConstant.SUFFER);
        jedis.lpush("USERINFO", echartParamStr);
        jedis.ltrim("USERINFO", -1, -20);
    }

}
