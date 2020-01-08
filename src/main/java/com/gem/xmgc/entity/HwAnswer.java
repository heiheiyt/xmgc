package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("hw_answer")
//开 ,燏 没用
public class HwAnswer implements Serializable {
    private static final long serialVersionUID = -6782713516855563505L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer taskId;
    public Integer teaId;
    public String path;
}
