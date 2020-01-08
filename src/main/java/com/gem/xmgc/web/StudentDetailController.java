package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.StudentDetail;
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
import java.text.ParseException;
import java.util.List;

/**
 * 档案Controller
 * @author jiowww
 * @data 2019/10/26.
 */
@Controller
@RequestMapping("/headTeacher/studentDetail")
@ResponseBody
public class StudentDetailController {

    @Autowired
    StudentService studentServiceImpl;

    @RequestMapping("/list")
    /**
     * 返回学生档案IPage对象
     */
    public IPage<StudentDetail> getStudentDetailList(Long id,String studentName,Integer current){
        if (current ==null) {
            current = 1;
        }
        return studentServiceImpl.findStudentDetailByIdOrName(id,studentName,current);
    }

    @RequestMapping("/search")
    public IPage<StudentDetail> getStudentDetailListBySName(Long id,String studentName){
        return studentServiceImpl.findStudentDetailByIdOrName(id,studentName,1);
    }

    @RequestMapping("/find")
    public StudentDetail getStudentDetailListById(String id){
        return studentServiceImpl.findStudentDetailById(Long.parseLong(id));
    }
//    @RequestMapping("/edit")
//    public Boolean editStudentDetailList(){
//        return true;
//    }
    @RequestMapping("/edit")
    public Boolean editStudentDetailList(StudentDetail sd) throws ParseException {
        return studentServiceImpl.editStudentDetail(sd);
    }

    @RequestMapping("/create")
    public Boolean createStudentDetailList(StudentDetail sd){
        return studentServiceImpl.createStudentDetail(sd);
    }
    @RequestMapping("/remove")
    public Boolean removeStudentDetailList(Long id){
        return studentServiceImpl.removeStudentDetail(id);
    }

    @RequestMapping("/removeBatch")
    public Boolean removeBatchStudentDetailList(@RequestParam(value = "ids[]") List<Long> ids){
        return studentServiceImpl.removeStudentDetails(ids);
    }

    @RequestMapping("/upLoad")
    public String upLoad(@RequestParam(value = "file_data",required = false) MultipartFile file, String type,Long cid) throws IOException, ClassNotFoundException {
        List<StudentDetail> list = UpDownUtil.getList(file,type);
        studentServiceImpl.uploadStudentDetails(list,cid);
        return "true";
    }

    @RequestMapping("/downLoad")
    public String exportExcelTest(HttpServletResponse response, String type, String excel, String sheet, String excelName,Long cid) throws ClassNotFoundException {
        List<StudentDetail> list = studentServiceImpl.findStudentDetailByCId(cid);
        UpDownUtil.exportExcel(response,type,list,excel,sheet,excelName);
        return "success";
    }

}
