package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 学科计划
 */
@Data
@TableName("subjectcontent")
public class SubjectContent implements Serializable {
    private static final long serialVersionUID = 8967036294687052106L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long subjectid;//学科名
    private Long type;//考试类型
    private Long thing;//计划编号
    @TableLogic
    private Integer statu;
    @TableField(exist = false)
    private String sname;//二级模块
    @TableField(exist = false)
    private String name;//测试类型
    @TableField(exist = false)
    private String typename;//学科
    @TableField(exist = false)
    private String fname;//一级模块
    @TableField(exist = false)
    private String fid;//一级模块id
    @TableField(exist = false)
    private String content;//二级模块id
}
