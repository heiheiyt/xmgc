package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.SubjectContent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
public interface SubjectContentMapper extends BaseMapper<SubjectContent> {
    IPage<SubjectContent> selectSubjectPlan(IPage<SubjectContent> iPage);
    IPage<SubjectContent> selectSubjectPlanBysubjectId(IPage<SubjectContent> iPage, @Param("subjectid") Long subjectid);
   @Select("select s.*,t.name,s2.s_name,sub.type_name,fi.f_name,s2.f_id,su.content from subjectcontent s join subjecttype sub on s.subjectid=sub.id join testtype t on s.type=t.id join secondlevel s2 join firstlevel fi on s2.f_id=fi.id join subjectcontentdetail su on su.content=s2.id where s.id=#{id} and s.statu=0 group by s.id")
    SubjectContent selectSubjectPlanById(Long id);

}
