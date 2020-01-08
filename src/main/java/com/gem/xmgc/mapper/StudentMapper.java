package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
public interface StudentMapper extends BaseMapper<Student> {
    //通过班级id查找班级所有学生id
    @Select("select id from student where c_id =#{id}")
    List<Integer> selectStudentIdsByClassId(@Param("id") String id);

    @Select("select * from student s where s.c_id in(select c_id from t_class where t_id=#{id}) and s.statu=0")
    List<Student> selectStudentByTeacherId(@Param("id") Long id);
    //根据实训师id查所带学生，分页
    IPage<Student> selectAllStudentByTid(IPage<Student> iPage, Long id);
}
