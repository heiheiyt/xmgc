package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 学科计划详情
 */
@Data
@TableName("subjectcontentdetail")
public class SubjectContentDetail implements Serializable {
    private static final long serialVersionUID = -7318027706091337503L;
   @TableId(type = IdType.AUTO)
    private Long id;
    private Long sid;//学科计划ID
    private Long content;//二级模块
    @TableLogic
    private Integer statu;
}
