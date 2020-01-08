package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 招生用户表
 */
@Data
@TableName("recruit")
public class Recruit implements Serializable {
    private static final long serialVersionUID = 8732948217609624372L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String rName;//姓名
    private String phone;//电话
    private String school;//学校
    private String major;//专业
    private String qq;//QQ
    private String wechat;//微信
    @TableLogic
    private Integer statu;//状态
}
