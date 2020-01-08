package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 问卷状态
 */
@TableName("searchtype")
@Data
public class SearchType implements Serializable {
    private static final long serialVersionUID = -2816778225613512460L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String typename;//问卷状态(发布,未发布,已发布)
}
