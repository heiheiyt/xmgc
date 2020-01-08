package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 4269041312017893616L;
    private Long id;
    //账号
    private String sId;
    //密码
    private String sPassword;
    //姓名
    private String sName;
    //班级
    private Long cId;
    //更新时间
    private Date upTime;
    //添加时间
    private Date addTime;
    //状态
    @TableLogic
    private Integer statu;
}
