package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.SecondLevel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
public interface SecondLevelMapper extends BaseMapper<SecondLevel> {
    @Select("select s.*,f.f_name,st.type_name from secondlevel s join firstlevel f on s.f_id=f.id join subjecttype st on f.type_id=st.id")
    IPage<SecondLevel> selectAllSecondLevels(IPage<SecondLevel> page);
    @Select("select s.*,f.f_name,st.type_name from secondlevel s join firstlevel f on s.f_id=f.id join subjecttype st on f.type_id=st.id where f.id=#{id}")
    IPage<SecondLevel> selectAllSecondLevelsById(IPage<SecondLevel> page, @Param("id") Long id);
    @Select("select s.*,f.f_name,st.type_name from secondlevel s join firstlevel f on s.f_id=f.id join subjecttype st on f.type_id=st.id where s.id=#{id}")
    SecondLevel selectSecondLevelsById(Long id);

}
