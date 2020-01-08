package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 满意度问卷
 */
@Data
@TableName("searchpapertype")
public class SearchPaperType implements Serializable {
    private static final long serialVersionUID = -8422733074099592518L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String tName;//问卷名称
    private String ps;//提示信息
    private Date starttime;//开始时间
    private Date stoptime;//截止时间
    @TableField(exist = false)
    private String cId;//班级名
    @TableField(exist = false)
    private LocalDateTime usedate;//调查时间
    @TableField(exist = false)
    private String t_name;//问卷名
    @TableField(exist = false)
    private String name;//状态

}
