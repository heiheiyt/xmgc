package com.gem.xmgc.entity;


import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 笔试面试
 */
public class WrittenIntervie implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = -4402320121180574482L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 学生id
     */
    private Long sid;

    /**
     * 模拟面试成绩
     */
    private Double fScore;

    /**
     * 面试最后录入时间
     */
    private Date fTime;

    /**
     * 模拟笔试成绩
     */
    private Double wScore;

    /**
     * 笔试最后录入时间
     */
    private Date wTime;

    /**
     * 状态
     */
    private Integer statu;

}
