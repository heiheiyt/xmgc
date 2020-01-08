package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.Score;
import com.gem.xmgc.entity.Student;
import com.gem.xmgc.service.ScoreService;
import com.gem.xmgc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/score")
public class SxsScoreController {
    @Autowired
    ScoreService scoreService;
    @Autowired
    StudentService studentService;
    @ResponseBody
    @GetMapping("/current")
    public IPage<Student> Current(HttpSession session, Integer current){
        if(current==null){
            current = 1;
        }
        Long cid = (Long) session.getAttribute("cid");
        Long tid = (Long) session.getAttribute("tid");
        if (cid==null){
            //当未选班师，按照老师id查询
            IPage<Student> studentIPage=studentService.findAllStudentsByTid(tid,current);
            studentIPage.getRecords().forEach(System.err::println);
            return studentIPage;
        }
        else{
            //已选班时，按照班级id查询
            IPage<Student> studentIPage=studentService.findAllStudentsByCId(cid,current);
            studentIPage.getRecords().forEach(System.err::println);
            return studentIPage;
        }

    }
    @GetMapping("/student/{studentid}")
    public String studentScore(@PathVariable("studentid")Long sid, Model model){
        //根据学生id查询成绩
        System.err.println(sid);
        List<Score> scores= scoreService.findScoresByStudentId(sid);
        scores.forEach(System.out::println);
        model.addAttribute("scoreList",scores);
        return "sxs/Trainer-paperscore";
    }
    @RequestMapping("/employment")
    public String Employment(){
        return "sxs/Trainer-employment";
    }
    @RequestMapping("/writtenresult")
    public String Writtenresult(){
        return "sxs/Trainer-writtenresult";
    }
}
