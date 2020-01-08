package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.gem.xmgc.entity.AllScoreObject;
import com.gem.xmgc.entity.StudentDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
public interface StudentDetailMapper extends BaseMapper<StudentDetail> {
    @Select("select cl.c_id as class_name,sd.* from student_detail sd join class cl on sd.c_id = cl.id ${ew.customSqlSegment} and sd.statu = 0")
    List<StudentDetail> findAllStudentDetails(@Param(Constants.WRAPPER) Wrapper<StudentDetail> queryWrapper);
}
