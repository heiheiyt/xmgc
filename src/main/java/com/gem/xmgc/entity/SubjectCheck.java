package com.gem.xmgc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 项目详情
 * @author jiowww
 * @data 2019/10/25.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("subjectcheck")
public class SubjectCheck {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学生id
     */
    private Long sId;

    /**
     * 线上是否提交
     */
    @Excel(name = "在线资料是否提交完毕",orderNum = "5")
    @TableField("online_check")
    private Submission onlineCheck;

    /**
     * 线下是否通过
     */
    @Excel(name = "线下验收是否通过",orderNum = "6")
    @TableField("under_check")
    private Pass underCheck;

    /**
     * 项目名称
     */
    @Excel(name = "答辩项目",orderNum = "2")
    private String subjectName;

    /**
     * 最后修改时间
     */
    @Excel(name = "最后修改时间",exportFormat = "yyyy-MM-dd",orderNum = "7")
    private LocalDateTime lastchangeTime;

    /**
     * 状态
     */
    @Excel(name = "备注",replace = {"在班_0","离班_1"},orderNum = "8")
    @TableLogic
    private Integer statu;
    @Excel(name = "学生姓名" ,orderNum = "1")
    @TableField(exist = false)
    private String sname;
    @Excel(name = "面试成绩",orderNum = "4")
    @TableField(exist = false)
    private Integer fscore;
    @Excel(name = "笔试成绩",orderNum = "3")
    @TableField(exist = false)
    private Integer wscore;
}
