package com.gem.xmgc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiowww
 * @data 2019/10/25.
 * me
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllScoreObject {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 学生姓名
     */
    @Excel(name = "账号")
    @TableField("s_name")
    private String sname;

    /**
     * 面试成绩
     */
    @Excel(name = "面试成绩", orderNum = "1")
    @TableField("f_score")
    private Double fscore;

    /**
     * 笔试成绩
     */
    @Excel(name = "笔试成绩", orderNum = "2")
    @TableField("w_score")
    private Double wscore;

    /**
     * 项目名称
     */
    @Excel(name = "项目名称", orderNum = "3")
    private String subjectName;

    /**
     * 线上是否提交
     */
    @Excel(name = "性别", orderNum = "4", replace = {"提交_SUBMISSION", "未提交_UN_SUBMISSION"})
    private Submission onlineCheck;

    /**
     * 线下是否通过
     */
    @Excel(name = "性别", orderNum = "5", replace = {"通过_PASS", "不通过_FAIL"})
    private Pass underCheck;

    /**
     * 简历是否合格
     */
    @Excel(name = "简历是否合格", orderNum = "6")
    private Qualified piResumeIsok;

    /**
     * 等级
     */
    @Excel(name = "等级", orderNum = "7")
    private String piComprehensiveQuality;
}
