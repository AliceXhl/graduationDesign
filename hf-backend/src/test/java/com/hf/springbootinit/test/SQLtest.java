package com.hf.springbootinit.test;

import com.hf.springbootinit.mapper.EchartMapper;
import com.hf.springbootinit.model.entity.EchartParam;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SQLtest {

    @Resource
    private EchartMapper echartMapper;

    @Test
    public void fun(){
        Map<String, BigDecimal> healCountList = echartMapper.sufHealCount();
        // [8,7]
        System.out.println(healCountList.get("total_no"));
        System.out.println(healCountList.get("total_yes"));
    }

}
