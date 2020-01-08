package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@TableName("applypaper")
//燏,开 没用
public class ApplyPaper implements Serializable {
    private static final long serialVersionUID = -5022880870820015717L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer sid;
    public Integer tid;
    public Integer uid;
    public LocalDateTime applydate;
    public String statu;
    public Integer sStatu;


}
