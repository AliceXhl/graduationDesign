package com.hf.springbootinit.controller;

import com.hf.springbootinit.common.BaseResponse;
import com.hf.springbootinit.common.ErrorCode;
import com.hf.springbootinit.common.ResultUtils;
import com.hf.springbootinit.exception.BusinessException;
import com.hf.springbootinit.model.dto.post.UserCheckRequest;
import com.hf.springbootinit.model.entity.EchartParam;
import com.hf.springbootinit.service.EchartService;
import com.hf.springbootinit.utils.EasyUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/check")
@Slf4j
public class UserCheckController {


    @Resource
    private EchartService echartService;

    /**
     * 单人检测
     * @param userCheckRequest
     * @param request
     * @return
     */
    @PostMapping("")
    public BaseResponse<EchartParam> checkUser(@RequestBody UserCheckRequest userCheckRequest, HttpServletRequest request) {
        String name = userCheckRequest.getName();
        String photo = userCheckRequest.getPhoto();
        String bmi = userCheckRequest.getBmi();
        String smoking = userCheckRequest.getSmoking();
        String drinking = userCheckRequest.getDrinking();
        String stroke = userCheckRequest.getStroke();
        String physicalhealth = userCheckRequest.getPhysicalhealth();
        String mentalhealth = userCheckRequest.getMentalhealth();
        String diffwalking = userCheckRequest.getDiffwalking();
        String sex = userCheckRequest.getSex();
        String agecategory = userCheckRequest.getAgecategory();
        String race = userCheckRequest.getRace();
        String diabetic = userCheckRequest.getDiabetic();
        String physicalactivity = userCheckRequest.getPhysicalactivity();
        String genhealth = userCheckRequest.getGenhealth();
        String sleeptime = userCheckRequest.getSleeptime();
        String asthma = userCheckRequest.getAsthma();
        String kidneydisease = userCheckRequest.getKidneydisease();
        String skincancer = userCheckRequest.getSkincancer();
        if (StringUtils.isAnyBlank(name, photo, bmi, smoking, drinking, stroke, physicalhealth, mentalhealth, diffwalking, sex,
                agecategory, race, diabetic, physicalactivity, genhealth, sleeptime, asthma, kidneydisease, skincancer)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数输入异常");
        }
        EchartParam echartParam = new EchartParam();
        try {
            BeanUtils.copyProperties(echartParam, userCheckRequest);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        String result = echartService.checkSingle(echartParam);
        echartParam.setHeartdisease(result);
        return ResultUtils.success(echartParam);
    }

    /**
     * 多人检测
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public BaseResponse<List<EchartParam>> uploadFile(@RequestPart("file") MultipartFile file, HttpServletRequest request) {

        if (file != null && file.getName().toLowerCase().matches(".*\\.(xls|xlsx)$")) {
            List<String> list;
            try {
                list = EasyUtils.readFile(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String result = null;
            /**
             * 第三方服务
             */
            List<EchartParam> echartParam = echartService.checkMul(list);
            return ResultUtils.success(echartParam);

        }
        return null;
    }
}
