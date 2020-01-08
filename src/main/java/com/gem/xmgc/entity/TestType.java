package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实训师
 * @author jiowww
 * @data 2019/10/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("testtype")
public class TestType implements Serializable {

    private static final long serialVersionUID = -3142453134692272253L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 测试类型（选择题，...）
     */

    private String name;
}
