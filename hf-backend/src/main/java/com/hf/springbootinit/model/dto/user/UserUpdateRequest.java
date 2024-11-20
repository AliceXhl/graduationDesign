package com.hf.springbootinit.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户更新请求
 *

 */
@Data
public class UserUpdateRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

    /**
     * 用户状态( 1--locked / 0--open )
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}