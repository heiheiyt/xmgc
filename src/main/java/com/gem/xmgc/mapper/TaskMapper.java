package com.gem.xmgc.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author jiowww
 * @data 2019/10/23.
 */
@Mapper
public interface TaskMapper extends BaseMapper<Task> {
    /*IPage<Task> selectTaskByClassId(IPage<Task> page,Long id);*/
    IPage<Task> selectTaskByOther(IPage<Task> iPage, @Param("id") Long id, @Param("time") String time, @Param("name") String name);


    /**
     *以下为新增
     */
    IPage<Task> selectTaskByTeacherId(IPage<Task> iPage,Long id,String time,String name);
    IPage<Task> selectTaskByClassId(IPage<Task> iPage,Long id,String time,String name);
    @Select("select t.* from task t where t.c_id in\n" +
            "(select c_id from t_class where t_id=#{id}) and t.statu=0")
    List<Task> selectTasksByTeacherId(Long id);

    String selectTaskTimeById(Long id);

    int updateTimeById(String ymd,String endTime,Long id);


}
