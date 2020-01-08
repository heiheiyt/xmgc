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
@TableName("taskdegree")
public class TaskDegree implements Serializable {
    private static final long serialVersionUID = -6261672973762902497L;
    /**
     * id
     */
    private Long id;

    /**
     *
     */
    private String degree;

}
