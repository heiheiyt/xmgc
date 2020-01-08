package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.Discipline;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author yt
 * @date 2019/10/23 20:50
 */
public interface DisciplineMapper extends BaseMapper<Discipline> {


    @Select("select s.s_name,d.* from student s join discipline d on s.id = d.student_id ${ew.customSqlSegment} and d.statu=0")
    IPage<Discipline> selectAllDisciplinesByCId(Page<Discipline> page, @Param(Constants.WRAPPER) Wrapper<Discipline> queryWrapper);


    @Select("select s.s_name,d.* from student s join discipline d on s.id = d.student_id ${ew.customSqlSegment} and d.statu=0")
    List<Discipline> selectDisciplinesByCId(@Param(Constants.WRAPPER) Wrapper<Discipline> queryWrapper);



    @Select("select s.s_name,d.* from student s join discipline d on s.id = d.student_id ${ew.customSqlSegment} and d.statu=0")
    Discipline selectDisciplineById(@Param(Constants.WRAPPER) Wrapper<Discipline> queryWrapper);

}
