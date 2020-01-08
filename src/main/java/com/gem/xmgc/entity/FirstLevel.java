package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 一级模块实体类
 */
@Data
@NoArgsConstructor
@TableName("firstlevel")
public class FirstLevel implements Serializable {
    private static final long serialVersionUID = 8489263636730817473L;
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("f_name")
    private String firstName;
    private Long typeId;//学科ID
    @TableField(exist = false)
    private String subjectName;
    @TableLogic
    private Long statu;//状态
}
