package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 通过和未通过
 * @author jiowww
 * @data 2019/10/25.
 */
@Getter
public enum Pass {
    PASS(0,"通过"),FAIL(1,"未通过");

    Pass(Integer code, String desc){
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
