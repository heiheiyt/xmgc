package com.gem.xmgc.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 笔试面试
 * add
 */
@TableName("written_intervie")
public class WrittenInterviewView implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = -4402320121180574482L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 学生id
     */
    private Long sId;

    /**
     * 模拟面试成绩
     */
    @Excel(name = "模拟面试成绩", orderNum = "1")
    @TableField("f_score")
    private Double fscore;

    /**
     * 面试最后录入时间
     */
    private Date fTime;

    /**
     * 模拟笔试成绩
     */
    @Excel(name = "模拟笔试成绩", orderNum = "2")
    @TableField("w_score")
    private Double wscore;

    /**
     * 笔试最后录入时间
     */
    private Date wTime;

    /**
     * 状态
     */
    private Integer statu;

    @Excel(name = "姓名")
    @TableField(exist = false,value = "s_name")
    private String sname;

}
