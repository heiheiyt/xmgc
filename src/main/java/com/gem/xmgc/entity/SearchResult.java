package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 问卷答案表
 */
@TableName("searchresult")
public class SearchResult implements Serializable {
    private static final long serialVersionUID = -6009821040937428465L;
    @TableId
    private Long id;
    private Long uid;//问卷Id
    private Long sid;//学生Id
    private Long itemid;//题目
    private String answer;//学生答案
}
