package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.SubjectCheck;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 项目详情
 * @author jiowww
 * @data 2019/10/25.
 */
public interface SubjectCheckMapper extends BaseMapper<SubjectCheck> {
    @Select("select s.*,stu.s_name,wi.f_score,wi.w_score from subjectcheck s join student stu join written_intervie wi where  s.s_id in(select id from student where c_id=#{classId}) and s.s_id=stu.id and wi.s_id=s.s_id")
    IPage<SubjectCheck> selectAllAnsProjectPage(Page<SubjectCheck> page,@Param("classId") String classId);
    @Select("select s.*,stu.s_name,wi.f_score,wi.w_score from subjectcheck s join student stu join written_intervie wi where  s.s_id in(select id from student where c_id=#{classId}) and s.s_id=stu.id and wi.s_id=s.s_id")
    List<SubjectCheck> selectAllAnsProject(@Param("classId") String classId);
}
