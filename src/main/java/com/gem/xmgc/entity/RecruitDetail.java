package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 招生试卷题目
 */
@Data
@TableName("recruitdetail")
public class RecruitDetail implements Serializable {
    private static final long serialVersionUID = 5346979292208033106L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String question;
    private String A;
    private String B;
    private String C;
    private String D;
    private String answer;
    private Long rId;
    @TableLogic
    private Integer statu;
}
