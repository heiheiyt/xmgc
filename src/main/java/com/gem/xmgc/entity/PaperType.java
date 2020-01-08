package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("papertype")
public class PaperType implements Serializable {
    private static final long serialVersionUID = 4551725302476394852L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public String pName;
}
