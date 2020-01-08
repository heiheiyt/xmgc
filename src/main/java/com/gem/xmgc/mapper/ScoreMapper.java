package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.gem.xmgc.entity.Score;
import com.gem.xmgc.entity.ScoreView;
import com.gem.xmgc.entity.StudentScore;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张开
 * @date 2019/10/23 21:03
 */
public interface ScoreMapper extends BaseMapper<Score> {
    /**
     * @author 张开
     * @date 2019/11/2 9:21
     * @description  通过试卷id查询试卷名
     */
    @Select("select p_name from paperinfo where id = (select p_id from usepaper where id = #{pid})")
     String selectPNameByPId(@Param("pid") Long pid);

    @Select("select s.score,p.p_name from score s left join usepaper u on s.u_id = u.id join paperinfo p on u.p_id = p.id ${ew.customSqlSegment} and s.statu = 0")
    List<Score> findScoresByStudentId(@Param(Constants.WRAPPER) Wrapper<Score> queryWrapper);


    @Select("select s.score,p.p_name from score s left join usepaper u on s.u_id = u.id join paperinfo p on u.p_id = p.id ${ew.customSqlSegment} and s.statu = 0")
    List<ScoreView> findScoresViewByStudentId(@Param(Constants.WRAPPER)Wrapper<ScoreView> queryWrapper);

    List<StudentScore> findStudentScoresByStudentId(@Param(Constants.WRAPPER)Wrapper<StudentScore> queryWrapper);


}
