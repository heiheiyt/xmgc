package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.Task;
import com.gem.xmgc.entity.TaskDetail;
import com.gem.xmgc.entity.TaskList;
import com.gem.xmgc.mapper.TaskDetailMapper;
import com.gem.xmgc.mapper.TaskListMapper;
import com.gem.xmgc.mapper.TaskMapper;
import com.gem.xmgc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yt
 * @date 2019/10/25 10:57
 */
@Service
@EnableAutoConfiguration
public class TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    TaskDetailMapper taskDetailMapper;
    @Autowired
    TaskListMapper taskListMapper;
    @Autowired
    AccountService accountService;




    /**
     * //通过日期和作业名称查询作业
     * @param id
     * @param time
     * @param name
     * @param current
     * @return
     */


    public IPage<Task> findTaskByOther(Long id, String time, String name,Integer current) {
        Page<Task> page = new Page<>(current,5);
        return taskMapper.selectTaskByOther(page,id,time,name);
    }
    
    /**
     * //编辑作业计划
     * @param task
     * @return
     */
    public int editTask(Task task) {
        return taskMapper.updateById(task);
    }

    /**
     * //创建作业计划(每天)
     * @param task
     * @param tname
     * @param cname
     * @return
     */
    public int createTask(Task task,String tname,String cname) {
        task.setTId(accountService.findTeacherOne(tname).getId());
        task.setCId(accountService.findManageOne(cname).getId());
        return taskMapper.insert(task);
    }

    /**
     *  //通过作业id查询作业题目(TaskList实体类(作业题库) TaskDetail(中间表)
     * @param id
     * @return
     */
    public IPage<TaskList> findTaskListByTid(Long id,Integer current) {
        Page<TaskList> page = new Page<>(current,5);
        return taskListMapper.selectTaskListById(page,id);
    }
    /**
     *   //编辑题库中的题目(一道)
     * @param taskList
     * @return
     */
    public int editTaskList(TaskList taskList) {
        return taskListMapper.updateById(taskList);
    }

    /**
     * //删除作业中的作业题目（taskid，tasklistid from  taskdetail）
     * @param taskid
     * @param tasklistid
     * @return
     */
    public int removeTasklistById(Long taskid, Long tasklistid) {
        LambdaQueryWrapper<TaskDetail> queryWrapper = Wrappers.<TaskDetail>lambdaQuery().eq(TaskDetail::getTId,taskid).eq(TaskDetail::getTaskId,tasklistid);
        return taskDetailMapper.delete(queryWrapper);
    }

    /**
     *  //新增作业中的作业题目(insert from  taskdetail(作业详情表，task作业id，tasklist作业题库中题目id))
     * @param taskDetail
     * @return
     */
    public int createTaskDetail(TaskDetail taskDetail) {
        return taskDetailMapper.insert(taskDetail);
    }




    /**
     * 新增
     * 根据实训id查询所带班级作业
     * @param tid
     * @param time
     * @param name
     * @param current
     * @return
     */
    public IPage<Task> findAllTaskByTeacherId(Long tid, String time, String name,Integer current){
        Page<Task> page = new Page<>(current,5);
        return taskMapper.selectTaskByTeacherId(page,tid,time,name);
    }
    /**
     * 新增
     * 通过一级模块id或者二级模块查询作业题目
     * @param fid
     * @param sid
     * @return
     */
    public List<TaskList> findTaskListByLevel(Long subjectId, Long fid, Long sid){
        return taskListMapper.selectByLevel(subjectId,fid,sid);
    }

    public int editTaskTime(Long id,String endTime){
        System.err.println("id"+id);
        String ymd = taskMapper.selectTaskTimeById(id);
        return taskMapper.updateTimeById(ymd+" ",endTime,id);

    }

    public List<Task> findTaskByTeacherId(Long tid){
        return taskMapper.selectTasksByTeacherId(tid);
    }

    /**
     * 根据班级id查询作业记录
     * @param cid
     * @param time
     * @param name
     * @param current
     * @return
     */
    public IPage<Task> findAllTaskByClassId(Long cid, String time, String name,Integer current){
        Page<Task> page = new Page<>(current,5);
        return taskMapper.selectTaskByClassId(page,cid,time,name);
    }

    public List<TaskList> findAllTaskByTid(Long tid){

        return taskListMapper.selectAllTaskByTid(tid);
    }
    public TaskList findTaskListById(Long id) {
        return taskListMapper.selectById(id);
    }

    /**
     * 2019/11/6新增
     * @param taskId
     * @param taskListId
     * @return
     */
    public int removeTaskListInTask(Long taskId,Long taskListId){
        QueryWrapper<TaskDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t_id",taskId);
        queryWrapper.eq("task_id",taskListId);
        return taskDetailMapper.delete(queryWrapper);
    }

}
