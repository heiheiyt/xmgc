package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("titlelist")
public class TitleList implements Serializable {

    private static final long serialVersionUID = -5245899924220706661L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 问题
     */
    private String question;

    /**
     * A答案
     */
    private String selecta;

    /**
     * B答案
     */
    private String selectb;

    /**
     * C答案
     */
    private String selectc;

    /**
     * D答案
     */
    private String selectd;

    /**
     * 正确答案
     */
    private String answer;

    /**
     * 学科id
     */
    private Long tId;

    /**
     * 二级标题id
     */
    private Long sLevel;

    /**
     * 作业题目类型id
     */
    private Long tType;

    /**
     * 实训师id
     */
    private Long teaId;

    /**
     * 状态
     */
    private Integer statu;
}
