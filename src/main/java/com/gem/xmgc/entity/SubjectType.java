package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 学科
 */
@Data
@TableName("subjecttype")
public class SubjectType implements Serializable {
    private static final long serialVersionUID = -6760930203742900544L;
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("type_name")
    private String typeName;//学科名
    @TableLogic
    private Long statu;//状态

}
