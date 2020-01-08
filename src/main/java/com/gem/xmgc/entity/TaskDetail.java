package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 作业详情表
 * @author jiowww
 * @data 2019/10/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("taskdetail")
public class TaskDetail implements Serializable {

    private static final long serialVersionUID = 8611381730625918025L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 实训师id
     */
    private Long tId;

    /**
     * 作业id
     */
    private Long taskId;

    /**
     * 更新时间
     */
    private LocalDateTime upTime;

    /**
     * 创建时间
     */
    private LocalDateTime addTime;

    /**
     * 备注
     */
    private Integer statu;
}

