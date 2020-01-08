package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 提交和未提交
 * @author jiowww
 * @data 2019/10/25.
 */
@Getter
public enum Submission {
    SUBMISSION(0,"提交"),NOT_SUBMOTTED(1,"未提交");

    Submission(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    @EnumValue
    private Integer code;
    private String desc;

    @Override
    public String toString() {
        return desc;
    }
}
