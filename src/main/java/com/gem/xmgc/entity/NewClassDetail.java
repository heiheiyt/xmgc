package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *班级测试计划
 */
@Data
@TableName("newclassdetail")
public class NewClassDetail implements Serializable {
    private static final long serialVersionUID = -2888323059529393455L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long cid;//班级
    private LocalDateTime date;//考试时间
    private Long thing;//学科计划外键
    @TableLogic
    private Integer statu;//状态
    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private String typeName;
    @TableField(exist = false)
    private String c_id;
    @TableField(exist = false)
    private String sname;
}
