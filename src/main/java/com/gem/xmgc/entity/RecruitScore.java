package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 成绩
 */
@Data
@TableName("recruitscore")
public class RecruitScore implements Serializable {
    private static final long serialVersionUID = 677330307234117099L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long rId;//用户主键
    private Long rp_id;//所属考试主键
    private Double mark;//分数
    @TableLogic
    private Integer statu;//状态
}
