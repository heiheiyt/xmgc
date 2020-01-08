package com.gem.xmgc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 纪律表
 * @author jiowww
 * @data 2019/10/22
 * me
 */
public class Discipline implements Serializable {

    private static final long serialVersionUID = -8392747711831859130L;


    //id
    private Long id;
    //创建时间
    @Excel(name = "创建时间", orderNum = "2",exportFormat = "yyyy-MM-dd", importFormat = "yyyy-MM-dd")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date createTime;
    //违纪类型
    @Excel(name = "违纪类型", orderNum = "1")
    private String type;
    //分数
    @Excel(name = "分数", orderNum = "3")
    private Integer score;
    //备注
    @Excel(name = "备注", orderNum = "4")
    private String remarks;
    //状态
    @TableLogic
    private Integer statu;
    //学生id
    private Long studentId;
    @Excel(name = "学生姓名")
    @TableField(exist = false,value = "s_name")
    private String sname;
}
