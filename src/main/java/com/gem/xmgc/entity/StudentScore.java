package com.gem.xmgc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @ClassName 学生分数实体类
 * @Author jiowww
 * @Date 2019/11/6
 *
 * me
 **/
@Data
public class StudentScore {

    @Excel(name = "姓名")
    @TableField("s_name")
    private String sname;


    @ExcelCollection(name = "成绩")
    List<ScoreView> scores;


}
