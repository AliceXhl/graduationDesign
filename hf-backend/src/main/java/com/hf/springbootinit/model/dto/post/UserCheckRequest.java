package com.hf.springbootinit.model.dto.post;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserCheckRequest implements Serializable {

    /**
     * 用户名
     */
    private String name;

    /**
     * 电话号
     */
    private String photo;

    /**
     * 体脂值
     */
    private String bmi;

    /**
     * 是否吸烟
     */
    private String smoking;

    /**
     * 是否饮酒
     */
    private String drinking;

    /**
     * 是否中风
     */
    private String stroke;

    /**
     * 物理健康天数/月
     */
    private String physicalhealth;

    /**
     * 心理健康天数/月
     */
    private String mentalhealth;

    /**
     * 是否能行走
     */
    private String diffwalking;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄段
     */
    private String agecategory;

    /**
     * 种族
     */
    private String race;

    /**
     * 是否有糖尿病
     */
    private String diabetic;

    /**
     * 是否运动过去一月内
     */
    private String physicalactivity;

    /**
     * 是否运动过去一月内
     */
    private String genhealth;

    /**
     * 每天的睡觉时间
     */
    private String sleeptime;

    /**
     * 是否哮喘
     */
    private String asthma;

    /**
     * 是否有肾病
     */
    private String kidneydisease;

    /**
     * 是否有皮肤癌
     */
    private String skincancer;
    private static final long serialVersionUID = 1L;
}
