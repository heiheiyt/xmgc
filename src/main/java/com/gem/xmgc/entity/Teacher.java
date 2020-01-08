package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *实训师
 */
@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = 6467243931938434128L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String tId;//账号
    private String tPassword;//密码
    private String tName;//姓名
    private Long typeId;//学科
    private LocalDateTime upTime;//更新时间
    private LocalDateTime addTime;//添加时间
    @TableLogic
    private Integer statu;//伪删除
    private String email;//邮箱
    private String flag;//是否为主管

}
