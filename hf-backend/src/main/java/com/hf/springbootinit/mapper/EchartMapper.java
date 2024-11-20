package com.hf.springbootinit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hf.springbootinit.model.entity.EchartParam;
import com.hf.springbootinit.model.vo.HeartDataCountVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* @author Admin
* @description 针对表【healthdata(心脏病数据)】的数据库操作Mapper
* @createDate 2024-10-31 14:32:37
* @Entity com.hf.springbootinit.model.entity.EchartParam
*/
public interface EchartMapper extends BaseMapper<EchartParam> {

    Map<String, BigDecimal> sufHealCount();

    List<EchartParam> userInfo();
}




