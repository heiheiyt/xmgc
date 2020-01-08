package com.gem.xmgc.web;

import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.TeacherMapper;
import com.gem.xmgc.service.ClazzServiceImpl;
import com.gem.xmgc.service.PaperService;
import com.gem.xmgc.service.StudentService;
import com.gem.xmgc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/trainer")
public class SxsTrainerController {
    @Autowired
    ClazzServiceImpl clazzService;
    @Autowired
    PaperService paperService;
    @Autowired
    TaskService taskService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherMapper teacherMapper;
    @GetMapping("/welcome")
    public String welcome(Model model,HttpSession session){
        //获取实训师id
        /**
         * 实训师id接入口
         */
       /* id=18L;
        session.setAttribute("tid",id);*/
        Long id = (Long) session.getAttribute("tid");
        //查询实训师名称

        System.err.println(id);
        Teacher teacher = teacherMapper.selectById(id);
        System.err.println("实训师"+teacher);
        model.addAttribute("teacher",teacher);

        //查询班级数量
        List<Clazz> clazzList = clazzService.findClazzByTeacherId(id);
        model.addAttribute("clazzCount",clazzList.size());

        //查询考试数量
        List<UsePaper> paperList = paperService.findPapers(id);
        model.addAttribute("paperCount",paperList.size());

        //查询作业数量
        List<Task> taskList = taskService.findTaskByTeacherId(id);
        model.addAttribute("taskCount",taskList.size());

        //查询学员数量
        List<Student> studentList= studentService.findStudentByTeacherId(id);
        model.addAttribute("studentCount",studentList.size());

        return "sxs/Trainer-welcome";
    }
}
