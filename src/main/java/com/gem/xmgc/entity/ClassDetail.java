package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @ClassName ClassDetail
 * @Description: TODO
 * @Author zy
 * @Date 2019/11/1
 * @Version V1.0
 **/
@Data
@TableName("newclassdetail")
public class ClassDetail {
    @TableId(type = IdType.AUTO)
    private Long id;
    private LocalDate date;//考试时间
    private Long thing;//学科计划外键
    @TableLogic
    private Integer statu;//状态
    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private String typeName;
    @TableField(exist = false)
    private String cid;
    @TableField(exist = false)
    private String sname;
}
