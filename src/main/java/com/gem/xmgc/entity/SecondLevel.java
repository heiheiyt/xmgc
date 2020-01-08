package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 二级模块
 */
@Data
@NoArgsConstructor
@TableName("secondlevel")
public class SecondLevel implements Serializable {
    private static final long serialVersionUID = 685850034316160559L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String sName;//二级模块名
    private Long fId;//一级模块id
    @TableLogic
    private Integer statu;
    @TableField(exist = false)
    private String fName;
    @TableField(exist = false)
    private String typeName;
}
