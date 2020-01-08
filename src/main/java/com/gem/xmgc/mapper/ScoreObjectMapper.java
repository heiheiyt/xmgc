package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.ScoreObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生成绩总表
 * @author jiowww
 * @data 2019/10/25.
 */
public interface ScoreObjectMapper {

   IPage<ScoreObject> selectScoreObjects(Page<ScoreObject> page, @Param(Constants.WRAPPER) Wrapper<ScoreObject> queryWrapper);
    //List<ScoreObject> selectScoreObjects(@Param(Constants.WRAPPER) Wrapper<ScoreObject> queryWrapper);
}
