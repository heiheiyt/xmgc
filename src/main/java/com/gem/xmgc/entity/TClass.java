package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 实训师-班级
 */
@Data
public class TClass implements Serializable {
    private static final long serialVersionUID = 1844270500656770315L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long tId;//实训师ID
    private Long cId;//班级ID
    private LocalDateTime upTime;//更新时间
    private LocalDateTime addTime;//添加时间
    @TableLogic
    private Integer statu;//状态
}
