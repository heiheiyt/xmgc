package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tasksocre")
public class TaskScore implements Serializable {

    private static final long serialVersionUID = 9080047606014219683L;
    /**
     * 主键id
     */
    private Long id;

    private Long taskid;

    private Long sid;

    private String degree;

}
