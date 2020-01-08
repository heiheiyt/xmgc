package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("usepaper")
public class UsePaper implements Serializable {

    private static final long serialVersionUID = -6050525370454798020L;
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 试卷id
     */

    private Long pId;
    //试卷名字
    @TableField(exist = false)
    private String pName;

    /**
     * 班级id
     */
    private Long cId;



    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime stopTime;

    /**
     * 修改时间
     */
    private LocalDateTime upTime;

    /**
     * 创建时间
     */
    private LocalDateTime addTime;

    /**
     * 状态
     */
    @TableLogic
    private Integer statu;
}
