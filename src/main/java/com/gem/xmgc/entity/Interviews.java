package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("interviews")
//开 ,燏 没用
public class Interviews implements Serializable {
    private static final long serialVersionUID = -8803172528625189381L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public String interviewName;
    public Integer tId;
    public Integer cId;
    public LocalDateTime setTime;
    public LocalDateTime startTime;
}
