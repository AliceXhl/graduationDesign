package com.hf.springbootinit.controller;

import com.hf.springbootinit.common.BaseResponse;
import com.hf.springbootinit.common.ResultUtils;
import com.hf.springbootinit.constant.CommonConstant;
import com.hf.springbootinit.model.entity.EchartParam;
import com.hf.springbootinit.service.EchartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 欢迎界面图表展示接口
 */
@RestController
@RequestMapping("/echart")
@Slf4j
public class chartController {

    @Resource
    private EchartService echartService;

    /**
     * @param request
     * @return
     */
    @GetMapping("")
    public BaseResponse<List<Object>> chartPage(HttpServletRequest request) {
        List<Object> list = new ArrayList<>();
        /**
         * 查询健康人数及患病人数
         */

        List<Integer> countList = echartService.sufHealCount();
        list.add(countList);
        /**
         * 展示最新患病人群（最多20人）
         * 及关键参数展示
         * 压缩
         */
        List<EchartParam> userInfoList = echartService.userInfo();
        list.add(userInfoList);

        return ResultUtils.success(list);
    }
}
