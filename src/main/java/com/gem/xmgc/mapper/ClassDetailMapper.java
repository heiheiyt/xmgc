package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.ClassDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName ClassDetailMapper
 * @Description: TODO
 * @Author zy
 * @Date 2019/11/1
 * @Version V1.0
 **/
public interface ClassDetailMapper extends BaseMapper<ClassDetail> {
    @Select("select n.cid,n.id,c.c_id,sub.type_name,t.`name`,s.thing,s.subjectid,n.date,se.s_name from newclassdetail n left join subjectcontent s on s.id=n.thing left join subjecttype sub on sub.id=s.subjectid left join testtype t on s.type=t.id left join class c on c.id=n.cid left join subjectcontentdetail  subje on subje.sid=s.id left join secondlevel se on subje.sid=se.id where n.statu=0 GROUP BY n.id ")
    IPage<ClassDetail> selectNewClassDetail(IPage<ClassDetail> page);
    @Select("select n.cid,n.id,c.c_id,sub.type_name,t.`name`,s.thing,s.subjectid,n.date,se.s_name from newclassdetail n left join subjectcontent s on s.id=n.thing left join subjecttype sub on sub.id=s.subjectid left join testtype t on s.type=t.id left join class c on c.id=n.cid left join subjectcontentdetail  subje on subje.sid=s.id left join secondlevel se on subje.sid=se.id where c.id=#{id} and n.statu=0 GROUP BY n.id  ")
    IPage<ClassDetail> selectNewClassDetailByClazz(IPage<ClassDetail> page, @Param("id") Long id);

}
