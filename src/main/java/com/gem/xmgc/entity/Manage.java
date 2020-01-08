package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * 班主任
 */
@Data
public class Manage implements Serializable {
    private static final long serialVersionUID = 5228298233781507503L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String mId;//账号
    private String mPassword;//密码
    private String mName;//姓名
    private String flag;//是否是主管
    private String email;//邮箱
    @TableLogic
    private Integer statu;//状态
}
