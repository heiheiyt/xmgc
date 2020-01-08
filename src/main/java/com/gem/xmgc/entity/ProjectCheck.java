package com.gem.xmgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *  项目验收
 * @author jiowww
 * @data 2019/10/23
 */
    //开 燏 没用到
public class ProjectCheck implements Serializable {

    private static final long serialVersionUID = -1947197954005664730L;
    //主键id
    private Long id;
    //答辩项目名称
    private String defencceProjectName;
    //项目验收是否通过
    private String projectAcceptance;
    //线上信息是否提交完毕
    private String onlineInformation;
    //最后修改时间
    private Date lastTime;
    //学生id
    private Long sId;
    //状态
    private Integer statu;
}
