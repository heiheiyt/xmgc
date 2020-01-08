package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 *  性别
 * @author jiowww
 * @data 2019/10/23
 * me
 */
@Getter
public enum Gender {
    MALE(0,"男"),FEMALE(1,"女");

    Gender(int code,String value){
        this.code = code;
        this.value = value;
    }

    @EnumValue
    private final int code;
    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
