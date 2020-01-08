package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("pat_student")
//开,燏 没用
public class PatStudent implements Serializable {
    private static final long serialVersionUID = 8363819073697524853L;
    public Integer id;
    public Integer pid;
    public Integer sid;
    public Integer statu;
}
