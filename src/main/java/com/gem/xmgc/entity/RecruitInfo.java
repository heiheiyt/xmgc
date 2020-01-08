package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 招生试卷
 */
@Data
@TableName("recruitinfo")
public class RecruitInfo implements Serializable {
    private static final long serialVersionUID = -3171323841160025575L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String rName;//试卷名
    @TableLogic
    private Integer statu;//状态
}
