package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 作业表
 */
@Data
@TableName("task")
public class Task implements Serializable {
    private static final long serialVersionUID = 5067238092439504875L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long tId;//实训师Id
    private Long cId;//班级ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime tSetTime;//创建时间
    private String taskPs;//备注
    private String taskName;//作业名
    private LocalDateTime tStopTime;//截止时间
    @TableLogic
    private Integer statu;//状态

    /**
     * 教师外键
     */
    @TableField(exist = false)
    private String tName;
    /**
     * 班级名称外键
     */
    @TableField(exist = false)
    private String cName;
}
