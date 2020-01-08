package com.gem.xmgc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 问卷题目
 */
@Data
@TableName("searchitem")
@AllArgsConstructor
@NoArgsConstructor
public class SearchItem implements Serializable {
    private static final long serialVersionUID = 3723859047732514466L;
    @TableId(type = IdType.AUTO)
    @Excel(name = "编号")
    private Long id;
    @Excel(name = "题目")
    private String question;//题目
    @TableField("selectA")
    @Excel(name = "选项A")
    private String selectA;
    @Excel(name = "选项B")
    @TableField("selectB")
    private String selectB;
    @Excel(name = "选项C")
    @TableField("selectC")
    private String selectC;
    @Excel(name = "选项D")
    @TableField("selectD")
    private String selectD;
    @Excel(name = "角色")
    @TableField("s_type")
    private Long type;//角色
    @TableLogic
    private Integer statu;
}
