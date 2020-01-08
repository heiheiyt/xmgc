package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("taskinfo")
public class TaskInfo implements Serializable {

    private static final long serialVersionUID = 6018308023144187858L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 学生id
     */
    private Long tId;

    /**
     * 图片路径
     */
    private  String imgAddress;

    /**
     * 更新时间
     */
    private LocalDateTime upTime;

    /**
     * 创建时间
     */
    private LocalDateTime addTime;
}
