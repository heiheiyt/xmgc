package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("accountall")
public class AccountAll implements Serializable {
    private static final long serialVersionUID = -4913543757026619004L;
    @TableId(type = IdType.AUTO)
    public Integer id;//账户id
    public String mNo;//账户名
    public String mPassword;//账户密码
    public String mEmail;//邮箱
    public String mName;//真实姓名
    public String mType;//账户类型
    @TableLogic
    public Integer mStatus;//账户状态
    @TableField(exist = false)
    public String subjecttype;
}
