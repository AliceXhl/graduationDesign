package com.hf.springbootinit.model.dto.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 用户登录请求
 *

 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;
    @JsonProperty("username")
    private String userAccount;
    @JsonProperty("password")
    private String userPassword;
}
