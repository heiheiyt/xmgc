package com.gem.xmgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *问卷详情
 */
@Data
@TableName("searchpaperdetail")
public class SearchPaperDetail implements Serializable {
    private static final long serialVersionUID = 1317798874012629777L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long paperId;//问卷
    private Long qId;//题目
    @TableLogic
    private Integer statu;

}
