package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.xmgc.entity.SubjectContentDetail;
import org.apache.ibatis.annotations.Select;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
public interface SubjectContentDetailMapper extends BaseMapper<SubjectContentDetail> {
    @Select("select s.* from subjectcontentdetail s join subjectcontent su on s.sid=su.id  where s.sid=#{id} group by su.id")
    SubjectContentDetail selectSbujectContentDetailById(Long id);

}
