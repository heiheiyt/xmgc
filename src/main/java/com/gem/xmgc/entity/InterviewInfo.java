package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("interviewinfo")
//开 ,燏 没用
public class InterviewInfo implements Serializable {
    private static final long serialVersionUID = 1915949633673071162L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer interId;
    public Integer taskId;
    public Integer examId;
}
