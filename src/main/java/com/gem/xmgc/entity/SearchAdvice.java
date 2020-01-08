package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 *问卷建议表
 */
@TableName("searchadvice")
public class SearchAdvice implements Serializable {
    private static final long serialVersionUID = -5264749809094374905L;
    private Long id;
    private Long usesearch;//问卷ID
    private Long sid;//学生Id
    private String advice;//建议
}
