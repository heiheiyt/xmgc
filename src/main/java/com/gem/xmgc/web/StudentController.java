package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.StudentView;
import com.gem.xmgc.service.StudentService;
import com.gem.xmgc.util.UpDownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author jiowww
 * @data 2019/10/31.
 */
@Controller
@RequestMapping("/headTeacher/student")
@ResponseBody
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/list")
    public IPage<StudentView> getStudentList(Long id,Integer current,String studentName){
        if(current == null){
            current = 1;
        }
        return studentService.findAllStudentByCId(id,current,studentName);
    }

    @RequestMapping("/nameList")
    public List<StudentView> getStudentListByCId(Long cId){
        return studentService.findAllStudentNameByCId(cId);
    }

    @RequestMapping("/sreach")
    public IPage<StudentView> findStudentByCIdAndStudentName(Long id,Integer current,String studentName){
        return studentService.findAllStudentByCId(id,1,studentName);
    }


    @RequestMapping("/find")
    public StudentView getStudent(Long id){
        return studentService.findStudentById(id);
    }


    @RequestMapping("/edit")
    public Boolean editStudent(StudentView student){
        return studentService.editStudent(student);
    }

    @RequestMapping("/create")
    public Boolean createStudent(StudentView student){
        student.setStatu(0);
        return studentService.createStudent(student);
    }

    @RequestMapping("/remove")
    public Boolean removeStudent(Long id){
        return studentService.removeStudentById(id);
    }

    @RequestMapping("/removeBatch")
    public Boolean removeBatchStudent(@RequestParam(value = "ids[]") List<Long> ids){
        return studentService.removeStudents(ids);
    }


    @RequestMapping("/upLoad")
    public String upLoad(@RequestParam(value = "file_data",required = false) MultipartFile file, String type, Long cid) throws IOException, ClassNotFoundException {
        List<StudentView> list = UpDownUtil.getList(file,type);
        studentService.createStudents(list,cid);
        return "true";
    }

    @RequestMapping("/downLoad")
    public String exportExcelTest(HttpServletResponse response, String type, String excel, String sheet, String excelName, Long cid) throws ClassNotFoundException {
        List<StudentView> list = studentService.findAllStudent(cid);
        UpDownUtil.exportExcel(response,type,list,excel,sheet,excelName);
        return "success";
    }






}
