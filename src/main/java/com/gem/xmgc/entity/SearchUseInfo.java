package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 已发布的问卷
 */
@Data
@TableName("Searchuseinfo")
public class SearchUseInfo implements Serializable {
    private static final long serialVersionUID = 882919099094620969L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long sid;//问卷ID
    private Long cid;//班级ID
    private Long flag;//标记1(未发布),2(进行中),3(已发布)
    private LocalDateTime usedate;//调查时间
    @TableLogic
    private Integer statu;

}
