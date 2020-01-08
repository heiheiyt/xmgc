package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 张开
 * @date 2019/10/23 19:48
 */
@Data
@TableName("emailcc")
public class Emailcc implements Serializable {
    private static final long serialVersionUID = -3322612625187174021L;
    @TableId(type = IdType.AUTO)
    public Integer id;
    public String username;
    public String email;
    @TableLogic
    public Integer statu;

}
