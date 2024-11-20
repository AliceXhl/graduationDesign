package com.hf.springbootinit.model.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSearchRequest implements Serializable {
    private String name;
    private String photo;
    private static final long serialVersionUID = 1L;
}
