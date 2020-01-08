package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 作业题库
 * @author jiowww
 * @data 2019/10/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tasklist")
public class TaskList implements Serializable {

    private static final long serialVersionUID = -8239039588728353500L;
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 题目
     */
    private String question;

    /**
     * 学科id
     */
    //////////////////////////////
    @TableField("t_id")
    private Long tid;
    /////////////////////////

    /**
     * 二级模块
     */
    /////////////
    @TableField("s_level")
    private Long slevel;
    //////////////////

    /**
     * 题目类型id
     */
    @TableField("t_type")
    private Long ttype;

    /**
     * 实训师id
     */
    @TableField("tea_id")
    private Long teaId;

    /**
     * 状态
     */
    @TableLogic
    private Integer statu;

    /**
     * 学科
     * 挂subjecttype表中type_name
     */
    @TableField(exist = false)
    private String typeName;

    /**
     * 二级模块
     * 挂secondlevel表中s_name字段
     */
    @TableField(exist = false)
    private String sname;

    /**
     * 题目类型
     * 挂titletype表中t_t_name字段
     */
    @TableField(exist = false)
    private String t_t_name;

    //教师名称外键
    @TableField(exist = false)
    public String tname;
}
