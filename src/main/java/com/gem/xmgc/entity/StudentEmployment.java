package com.gem.xmgc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *  工作详情表
 * @author jiowww
 * @data 2019/10/23
 * me
 */
public class StudentEmployment implements Serializable {
    /**
     * 序列化id
     */

    private static final long serialVersionUID = -191387491718931512L;

    /**
     * 主键id
     */
    @TableId("s_employment_id")
    private Long semploymentid;
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    @TableField("s_employment_name")
    private String semploymentname;

    /**
     * 就业情况(是否就业)
     */
    @Excel(name = "就业情况", orderNum = "1", replace = {"男_LATE", "女_ABSENCE_FROM_DUTY"}, suffix = "生")
    @TableField("s_employment_state")
    private BooleanEnum semploymentstate;


    /**
     * 就业城市
     */
    @Excel(name = "就业公司", orderNum = "2")
    @TableField("s_employment_city")
    private String semploymentcity;

    /**
     * 就业公司
     */
    @Excel(name = "就业公司", orderNum = "3")
    @TableField("s_employment_enterprise")
    private String semploymententerprise;

    /**
     * 实习薪资
     */
    @Excel(name = "实习薪资", orderNum = "4")
    @TableField("s_employment_inernship_salary")
    private String semploymentinernshipsalary;

    /**
     * 福利待遇
     */
    @Excel(name = "福利待遇", orderNum = "5")
    @TableField("s_employment_welfare_treatment")
    private String semploymentwelfaretreatment;

    /**
     * 正式薪资
     */
    @Excel(name = "正式薪资", orderNum = "6")
    @TableField("s_employment_official_salary")
    private String semploymentofficialsalary;

    /**
     * 推荐老师
     */
    @Excel(name = "推荐老师", orderNum = "7")
    @TableField("s_employment_recommended_teacher")
    private String semploymentrecommendedteacher;

    /**
     * 所属班级名称
     */
    @Excel(name = "所属班级名称", orderNum = "8")
    @TableField("s_employment_class_name")
    private String semploymentclassname;

    /**
     * 备注
     */
    @Excel(name = "备注", orderNum = "9")
    @TableField("s_employment_remark")
    private String semploymentremark;


    /**
     * 备注
     */
    @TableField(exist = false)
    private String flag;
}
