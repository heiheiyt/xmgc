package com.gem.xmgc.CRMentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAPI {
    //学生id
    private String stuName;
    //是否就业
    private String employee;
    //就业城市
    private String employeecity;
    //就业公司
    private String company;
    //职位
    private String position;
    //实习薪资
    private Double internshipsalary;
    //福利待遇
    private String welfare;
    //正式薪资
    private Double officialsalary;
    //推荐老师
    private String recommendedteacher;
    //标识
    private Integer flag;
    //备注
    private String extra;
}
