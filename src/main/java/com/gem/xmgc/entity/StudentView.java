package com.gem.xmgc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *  学生账号
 * @author jiowww
 * @data 2019/10/23
 * add
 */
@TableName("student")
public class StudentView implements Serializable {

    private static final long serialVersionUID = 4269041312017893616L;
    private Long id;

    //账号
    @Excel(name = "账号")
    @TableField("s_id")
    private String sid;
    //密码
    @TableField("s_password")
    private String spassword;
    //姓名
    @Excel(name = "姓名", orderNum = "1")
    @TableField("s_name")
    private String sname;
    //班级
    @TableField("c_id")
    private Long cid;
    //更新时间
    private Date upTime;
    //添加时间
    private Date addTime;
    //状态
    @TableLogic
    private Integer statu;
}
