package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
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
 */
@TableName("score")
public class Score implements Serializable {

    private static final long serialVersionUID = 4308875894343994655L;
    @TableId(type = IdType.AUTO)
    private Long id;
    //分数
    private Double score;
    //更新时间
    private Date up_time;
    //添加时间
    private Date add_time;
    //状态
    @TableLogic
    private Integer statu;
    //学生id
    private Long sId;
    //使用试卷
    private Long uId;
    //使用试卷名
    @TableField(exist = false )
    private String pname;
}
