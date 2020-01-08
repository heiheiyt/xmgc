package com.gem.xmgc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *  分数
 * @author jiowww
 * @data 2019/10/23
 * add
 */
public class ScoreView implements Serializable {

    private static final long serialVersionUID = 4308875894343994655L;
    private Long id;


    //分数
    @Excel(name = "分数",orderNum = "1")
    private Double score;
    //更新时间
    private Date upTime;
    //添加时间
    private Date addTime;
    //状态
    private Integer statu;
    //学生id
    @TableField("s_id")
    private Long sid;
    //使用试卷
    @TableField("u_id")
    private Long uid;

    @Excel(name = "试卷名")
    @TableField(value = "p_name",exist = false)
    private String pname;


}
