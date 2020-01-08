package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 已发布的问卷状态
 */
@Data
@TableName("searchpaperstatu")
public class SearchPaperStatu implements Serializable {
    private static final long serialVersionUID = -3714477266191317480L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
}
