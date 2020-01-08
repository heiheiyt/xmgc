package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gem.xmgc.XmgcApplicationTests;
import com.gem.xmgc.entity.StudentDetail;
import com.gem.xmgc.entity.TaskDetail;
import com.gem.xmgc.mapper.StudentDetailMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.channels.Pipe;

/**
 * @author yt
 * @date 2019/10/25 11:41
 */
public class TaskServiceImplTest extends XmgcApplicationTests {

    @Autowired
    StudentDetailMapper studentDetailMapper;
    @Test
    public void f(){
        QueryWrapper<StudentDetail> queryWrapper = Wrappers.query();
        queryWrapper.eq("sd.c_id",3L);
      studentDetailMapper.findAllStudentDetails(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void findTaskByOtherTest(){

        taskService.findTaskByOther(16L,"2018-07-30",null,1).getRecords().forEach(System.out::println);
    }
    @Test
    public void findTaskListByTidTest(){
        taskService.findTaskListByTid(14L,1).getRecords().forEach(System.out::println);
    }
    @Test
    public void removeTasklistByIdTest(){
        taskService.removeTasklistById(14L,241L);
    }
    @Test
    public void createTaskDetailTest(){
        TaskDetail taskDetail = new TaskDetail();
        taskDetail.setTId(14L);
        taskDetail.setTaskId(241L);
        taskService.createTaskDetail(taskDetail);
    }
    @Test
    public void findTaskListByIdTest(){
        System.out.println(taskService.findTaskListById(241L));
    }



}
