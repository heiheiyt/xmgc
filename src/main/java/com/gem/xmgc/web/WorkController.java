package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.StudentEmployment;
import com.gem.xmgc.service.StudentService;
import com.gem.xmgc.util.UpDownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 就业
 * @author jiowww
 * @data 2019/10/26.
 */
@Controller
@RequestMapping("/headTeacher/work")
@ResponseBody
public class WorkController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/list")
    public IPage<StudentEmployment> getWorkDetailLists(Long id, String sEmploymentName, Integer current){
        if (current == null){
            current = 1;
        }




        return studentService.findWorkDetailsByIdAndName(id,sEmploymentName,current);
    }

    @RequestMapping("/search")
    public IPage<StudentEmployment> getWorkDetailListByName(Long id,String studentName){



        return studentService.findWorkDetailsByIdAndName(id,studentName,1);
    }

    @RequestMapping("/downLoad")
    public String exportExcelTest(HttpServletResponse response, String type, String excel, String sheet, String excelName, Long cid) throws ClassNotFoundException {
        List<StudentEmployment> list = studentService.findAllWorkDetailsById(cid);
        UpDownUtil.exportExcel(response,type,list,excel,sheet,excelName);
        return "success";
    }
}
