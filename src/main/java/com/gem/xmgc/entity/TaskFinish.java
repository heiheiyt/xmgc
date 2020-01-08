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
@TableName("taskfinish")
public class TaskFinish implements Serializable {

    private static final long serialVersionUID = -1534471646627934163L;
    /**
     * 主键id
     */
    private Long id;

    private Long taskid;

    private Long sid;

    private LocalDateTime finishtime;

    private Integer ischeck;
}
