package com.gem.xmgc.controller;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *学生答案
 * @author zy
 */
@TableName("stuanswer")
@Data
public class StuAnswer implements Serializable {
    private static final long serialVersionUID = -187662323321811126L;
    private Long id;
    private Long stuPaper; //学生id
    private Long titleid;//题目ID
    private String answer;//回答的答案
}
