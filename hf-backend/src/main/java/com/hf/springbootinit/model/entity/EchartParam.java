package com.hf.springbootinit.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.hf.springbootinit.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 心脏病数据
 * @TableName healthdata
 */
@TableName(value ="healthdata")
@EqualsAndHashCode(callSuper = true)
@Data
public class EchartParam  extends PageRequest implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 电话号
     */
    private String photo;

    /**
     * 是否有心脏病
     */
    private String heartdisease;

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
    private Double physicalhealth;

    /**
     * 心理健康天数/月
     */
    private Double mentalhealth;

    /**
     * 是否能行走
     */
    private String diffwalking;

    /**
     * 性别
     */
    private Object sex;

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
    private Integer sleeptime;

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

    /**
     *
     */
    private Date createtime;

    /**
     * 信息所属组，默认属于超级用户
     */
    private Integer groupid;

    /**
     * 1delete;0notdelete
     */
    @TableLogic
    private Object isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}