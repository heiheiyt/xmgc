package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("paperinfo")
public class PaperInfo implements Serializable {
    private static final long serialVersionUID = -1601224262062971505L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public String pname;
    public LocalDateTime ptime;
    public Integer pteacher;
    public Integer typeId;
    public LocalDateTime upTime;
    public LocalDateTime addTime;
    public String ptype;
    public Integer flag;
    @TableLogic
    public Integer statu;
    //教师名称外键
    @TableField(exist = false)
    public String tname;
    @TableField(exist = false)
    public String typeName;
}
