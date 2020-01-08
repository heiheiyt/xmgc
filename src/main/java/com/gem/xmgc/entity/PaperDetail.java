package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("paperdetail")
public class PaperDetail implements Serializable {
    private static final long serialVersionUID = -2763418659312748033L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer pId;
    public Integer tId;
    public LocalDateTime upTime;
    public LocalDateTime addTime;
    public Integer statu;
}
