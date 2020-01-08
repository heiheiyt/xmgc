package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.TaskList;

import java.util.List;

public interface TaskListMapper extends BaseMapper<TaskList> {
    IPage<TaskList> selectTaskListById(IPage<TaskList> page, Long id);


    List<TaskList> selectAllTaskByTid(Long id);

    /**
     * new
     */
    List<TaskList> selectByLevel(Long subjectId, Long fid,Long sid);
}
