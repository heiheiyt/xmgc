package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * 班主任-班级
 */
@Data
public class MClass implements Serializable {
    private static final long serialVersionUID = 2993917384705354315L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long mId;//班主任ID
    private Long cId;//班级ID
    @TableLogic
    private Long statu;
}
