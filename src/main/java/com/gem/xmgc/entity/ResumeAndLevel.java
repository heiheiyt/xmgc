package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *  简历
 * @author jiowww
 * @data 2019/10/23
 */
@Data
@TableName("resumeandlevel")
public class ResumeAndLevel implements Serializable {

    private static final long serialVersionUID = 898961890353738674L;
    //简历是否合格
    private String resume;
    //等级
    private String Level;
}
