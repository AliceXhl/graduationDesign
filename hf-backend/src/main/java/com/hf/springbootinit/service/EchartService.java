package com.hf.springbootinit.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hf.springbootinit.model.dto.post.EchartUserRequest;
import com.hf.springbootinit.model.entity.EchartParam;

import java.util.List;

/**
 * 可视化界面服务
 *
 */
public interface EchartService extends IService<EchartParam> {


    void currentUser(EchartUserRequest echartUser);

    List<Integer> sufHealCount();

    List<EchartParam> searchUser(EchartParam echartParam);

    QueryWrapper<EchartParam> userList(EchartParam echartParam);

    List<EchartParam> userInfo();

    String checkSingle(EchartParam echartParam);

    List<EchartParam> checkMul(List<String> list);
}
