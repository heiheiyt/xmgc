package com.gem.xmgc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * 成绩(页面显示)
 * @author jiowww
 * @data 2019/10/25.
 */
@Data
public class ScoreObject {

    /**
     * 学生id
     */
    Long id;

    /**
     * 学生姓名
     */
    String sName;

    /**
     * 试卷名/成绩map
     */
    List<Map<String, Double>> tSMap;
}