package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 合格和不合格
 * @author jiowww
 * @data 2019/10/25.
 */
@Getter
public enum Qualified {
    QUALIFIED(0,"合格"),UNQUALIFIED(1,"不合格");

    Qualified(Integer code, String desc){
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
