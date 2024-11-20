package com.hf.springbootinit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hf.springbootinit.common.BaseResponse;
import com.hf.springbootinit.common.ErrorCode;
import com.hf.springbootinit.common.ResultUtils;
import com.hf.springbootinit.exception.BusinessException;
import com.hf.springbootinit.exception.ThrowUtils;
import com.hf.springbootinit.model.dto.user.UserSearchRequest;
import com.hf.springbootinit.model.entity.EchartParam;
import com.hf.springbootinit.service.EchartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 用户管理接口
 */
@RestController
@RequestMapping("/post")
@Slf4j
public class UserManageController {

    @Resource
    private EchartService echartService;

    @PostMapping("/search")
    public BaseResponse<List<EchartParam>> searchUser(@RequestBody UserSearchRequest searchRequest, HttpServletRequest request){
        if (StringUtils.isAnyBlank(searchRequest.getName(), searchRequest.getPhoto())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        EchartParam echartParam = new EchartParam();
        try {
            BeanUtils.copyProperties(echartParam, searchRequest);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        List<EchartParam> userList = echartService.searchUser(echartParam);
        return ResultUtils.success(userList);
    }

    @PostMapping("")
    public BaseResponse<Page<EchartParam>> userListByPage(@RequestBody EchartParam pageQuery, HttpServletRequest request){

        long current = pageQuery.getCurrent();
        long size = pageQuery.getPageSize();
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<EchartParam> infoPage = echartService.page(new Page<>(current, size),
                echartService.userList(pageQuery));
        return ResultUtils.success(infoPage);
    }

}
