package com.hf.springbootinit.model.dto.post;

import lombok.Data;

import java.io.Serializable;

@Data
public class EchartUserRequest implements Serializable {

    private String name;
    private String photo;

    private static final long serialVersionUID = 1L;
}
