package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.Clazz;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yt
 * @date 2019/10/23 20:50
 */
public interface ClazzMapper extends BaseMapper<Clazz> {
    @Select("select c.*,t.t_name,m.m_name,s.type_name from class c left join t_class tc on c.id=tc.c_id left join teacher t on tc.t_id=t.id left join m_class mc on c.id=mc.c_id left join manage m on m.id=mc.m_id left join subjecttype s on s.id=c.type_id where c.start_year=#{start_year} and s.type_name=#{subject} ")
    IPage<Clazz> selectClazzY(IPage<Clazz> page, @Param("start_year") String start_year, @Param("subject") String subject);


    @Select("select c.* from class c join t_class t on c.id=t.c_id where t.t_id=#{t_id} and c.statu=0")
    IPage<Clazz> selectClazzByTId(IPage<Clazz> page, @Param("t_id") Long id);

    @Select("select c.* from class c join t_class t on c.id=t.c_id where t.t_id=#{t_id} and t.statu=0")
    List<Clazz> selectClazzByTid(@Param("t_id") Long id);

    @Select("select c.* from class c join m_class m on c.id=m.c_id where m.m_id=#{m_id} and c.statu=0")
    IPage<Clazz> selectClazzByMId(IPage<Clazz> page, @Param("m_id") Long id);
    @Select("select c.*,m.m_name,t.t_name,tt.t_id,mm.m_id, type.type_name from class c join manage m join m_class mm join teacher t join t_class tt on t.id=tt.t_id  on c.id=tt.c_id JOIN subjecttype type ON type.id = c.type_id  where c.statu=0 group by c.id ")
    IPage<Clazz> selectAllClazz(IPage<Clazz> page);
    @Select("select c.*,m.m_name,t.t_name,tt.t_id,mm.m_id, type.type_name from class c join manage m join m_class mm join teacher t join t_class tt on t.id=tt.t_id  on c.id=tt.c_id JOIN subjecttype type ON type.id = c.type_id  where c.id=#{id} and c.statu=0 group by c.id ")
    Clazz selectAllClazzById(@Param("id") Long id);
    @Select("select c.*,t.t_name,m.m_name,s.type_name from class c left join t_class tc on c.id=tc.c_id left join teacher t on tc.t_id=t.id left join m_class mc on c.id=mc.c_id left join manage m on m.id=mc.m_id left join subjecttype s on s.id=c.type_id")
    IPage<Clazz> selectAllClazzInfo(IPage<Clazz> page);

    @Select("select c.* from class c join m_class m on c.id=m.c_id where m.m_id=#{value} ")
    List<Clazz> selectClazzByMid(Long id);






    @Select("select c.*,t.t_name,m.m_name,s.type_name from class c left join t_class tc on c.id=tc.c_id left join teacher t on tc.t_id=t.id left join m_class mc on c.id=mc.c_id left join manage m on m.id=mc.m_id left join subjecttype s on s.id=c.type_id where c.start_year=#{start_year}")
    IPage<Clazz> selectClazzByYear(IPage<Clazz> page, @Param("start_year") String start_year);
    @Select("select c.*,t.t_name,m.m_name,s.type_name from class c left join t_class tc on c.id=tc.c_id left join teacher t on tc.t_id=t.id left join m_class mc on c.id=mc.c_id left join manage m on m.id=mc.m_id left join subjecttype s on s.id=c.type_id where s.type_name=#{subject} ")
    IPage<Clazz> selectClazzBySubject(IPage<Clazz> page, @Param("subject") String subject);

    @Select("select start_year from class  c  group by c.start_year;")
    List<Clazz> selectyears();
}
