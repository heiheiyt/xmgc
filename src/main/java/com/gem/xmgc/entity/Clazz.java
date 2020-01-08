package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 班级实体类
 *
 */
@Data
@TableName("class")
public class Clazz implements Serializable {
    private static final long serialVersionUID = -2785213668186471519L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String cId;//班级编号
    private Long typeId;//学科
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDateTime upTime;//更新时间
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDateTime addTime;//添加时间
    private String startYear;//所属年份
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDateTime staatDate;//开班日期
    @TableLogic
    private String statu;//状态
    @TableField(exist = false)
    private Long tId;//实训师Id
    @TableField(exist = false)
    private Long mId;//班主任ID
    @TableField(exist = false)
    private String tName;//实训师Id
    @TableField(exist = false)
    private String mName;//班主任ID
    @TableField(exist = false)
    private String typename;//班主任ID

}
