package com.hf.springbootinit.controller;

import com.hf.springbootinit.common.BaseResponse;
import com.hf.springbootinit.common.ResultUtils;
import com.hf.springbootinit.model.entity.EchartParam;
import com.hf.springbootinit.service.EchartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 欢迎界面图表展示接口
 */
@SpringBootTest
public class chart {

    @Resource
    private EchartService echartService;

    @Test
    public void chartPage() {
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

        System.out.println(list);
    }
}
