package com.gem.xmgc.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.naming.Name;
import java.io.Serializable;
import java.util.Date;

@Data

/**
 *  档案
 * @author jiowww
 * @data 2019/10/23
 * me
 */
public class StudentDetail implements Serializable {
    private static final long serialVersionUID = -5242405148682148993L;
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学生姓名
     */
    @Excel(name = "姓名")
    @TableField("c_name")
    private String cname;

    /**
     * 班级名称
     */
    @Excel(name = "班级名称", orderNum = "1")
    @TableField(value = "class_name",exist = false)
    private String className;

    /**
     * 班级编号
     */
    @TableField("c_id")
    private Long cid;

    /**
     * 性别
     */
    @Excel(name = "性别", orderNum = "2", replace = {"男_MALE", "女_FEMALE"}, suffix = "生")
    private Gender sex;

    /**
     * 学校名称
     */
    @Excel(name = "学校名称", orderNum = "3")
    @TableField("s_name")
    private String sname;

    /**
     * 专业
     */
    @Excel(name = "专业", orderNum = "4")
    private String major;

    /**
     * 外语水平
     */
    @Excel(name = "外语水平", orderNum = "5")
    private String language;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号", orderNum = "6")
    private String idCard;

    /**
     * 移动电话
     */
    @Excel(name = "移动电话", orderNum = "7")
    private String telephone;

    /**
     * qq号码
     */
    @Excel(name = "qq号码", orderNum = "8")
    private String qq;

    /**
     * 培训类型
     */
    @Excel(name = "培训类型", orderNum = "9")
    @TableField("t_type")
    private String ttype;

    /**
     * 证书
     */
    @Excel(name = "证书", orderNum = "10")
    private String certificate;

    /**
     * 籍贯
     */
    @Excel(name = "籍贯", orderNum = "11")
    @TableField("s_native")
    private String snative;

    /**
     * 学校类型
     */
    @Excel(name = "学校类型", orderNum = "12")
    @TableField("s_type")
    private String stype;

    /**
     * 学历
     */
    @Excel(name = "学历", orderNum = "13")
    private String education;

    /**
     * 毕业时间
     */
    @Excel(name = "毕业时间", orderNum = "14", exportFormat = "yyyy-MM-dd", importFormat = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date graTime;

    /**
     * 家长姓名
     */
    @Excel(name = "家长姓名", orderNum = "15")
    @TableField("p_name")
    private String pname;

    /**
     * 家庭电话
     */
    @Excel(name = "家庭电话", orderNum = "16")
    @TableField("f_tel")
    private String ftel;

    /**
     * 家庭现住址
     */
    @Excel(name = "家庭现住址", orderNum = "17")
    private String address;

    /**
     * 紧急联系人电话
     */
    @Excel(name = "紧急联系人电话", orderNum = "18")
    @TableField("p_tel")
    private String ptel;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱", orderNum = "19")
    private String email;

    /**
     * 年份
     */
    @Excel(name = "年份", orderNum = "20")
    private String year;

    /**
     * 就业类型
     */
    @Excel(name = "就业类型", orderNum = "21")
    @TableField("w_type")
    private String wtype;

    /**
     * 就业状态
     */
    @Excel(name = "就业状态", orderNum = "22")
    @TableField("w_status")
    private String wstatus;

    /**
     * 质量执行
     */
    @Excel(name = "质量执行", orderNum = "23")
    private String quaexecution;

    /**
     * 招生老师
     */
    @Excel(name = "招生老师", orderNum = "24")
    @TableField("rec_teacher")
    private String recteacher;

    /**
     * 实训师
     */
    @Excel(name = "实训师", orderNum = "25")
    private String trainer;

    /**
     * 信息创建人
     */
    @Excel(name = "信息创建人", orderNum = "26")
    @TableField("create_per")
    private String createper;

    /**
     * 地域
     */
    @Excel(name = "地域", orderNum = "27")
    private String area;

    /**
     * 学生状态
     */
    @Excel(name = "学生状态", orderNum = "28")
    @TableField("stu_status")
    private String stustatus;

    /**
     * 备注
     */
    @Excel(name = "备注", orderNum = "39")
    private String remarks;

    /**
     * 状态
     */
    @TableLogic
    private Integer statu;
}


