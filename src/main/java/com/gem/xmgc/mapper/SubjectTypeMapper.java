package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.xmgc.entity.SubjectType;
import org.apache.ibatis.annotations.Select;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
public interface SubjectTypeMapper extends BaseMapper<SubjectType> {
    /**
     * 通过实训师id查询学科名字
     */
    @Select("select s.* from subjecttype s join teacher t on s.id=t.type_id where t.id=#{id} and s.statu=0 and t.statu=0")
    SubjectType selectSubjectByTeacherId(Long id);
}
