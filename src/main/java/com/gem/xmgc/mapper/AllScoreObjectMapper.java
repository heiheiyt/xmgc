package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.AllScoreObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jiowww
 * @data 2019/10/25.
 */
public interface AllScoreObjectMapper {

    @Select("select s.s_name,w.f_score,w.w_score,su.subject_name,su.online_check,su.under_check,cr.pi_resume_isok,cr.pi_comprehensive_quality from class c left join student s on c.id = s.c_id left join subjectcheck su on s.id = su.s_id left join written_intervie w on s.id = w.s_id left join crm_part_information cr on s.id = cr.pi_student_id ${ew.customSqlSegment}")
    IPage<AllScoreObject> selectAllScoreObjects(Page<AllScoreObject> page, @Param(Constants.WRAPPER) Wrapper<AllScoreObject> queryWrapper);

    @Select("select s.s_name,w.f_score,w.w_score,su.subject_name,su.online_check,su.under_check,cr.pi_resume_isok,cr.pi_comprehensive_quality from class c left join student s on c.id = s.c_id left join subjectcheck su on s.id = su.s_id left join written_intervie w on s.id = w.s_id left join crm_part_information cr on s.id = cr.pi_student_id ${ew.customSqlSegment}")
    List<AllScoreObject> selectScoreObjects(@Param(Constants.WRAPPER) Wrapper<AllScoreObject> queryWrapper);

}
