package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("classlevelprob")
//燏,开没用
public class ClassLevelProb implements Serializable {
    private static final long serialVersionUID = 1467959297690161767L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer cid;
    public Integer levelid;
    public Float score;
}
