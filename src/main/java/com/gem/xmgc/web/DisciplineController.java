package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gem.xmgc.entity.Discipline;
import com.gem.xmgc.service.StudentService;
import com.gem.xmgc.util.UpDownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 违纪控制器
 * @author jiowww
 * @data 2019/10/28.
 */
@Controller
@RequestMapping("/headTeacher/discipline")
@ResponseBody
public class DisciplineController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/list")
    public IPage<Discipline> getDisciplineList(Long id,String date,String type,String studentName,Integer current){
        if (current == null){
            current = 1;
        }
        LocalDateTime ldt = null;
        if(StringUtils.isNotEmpty(date)){
            DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ld = LocalDate.parse(date,df);
            ldt = ld.atStartOfDay();
        }
        return studentService.findDisciplineByCondition(id,ldt,studentName,type,current);
    }

    @RequestMapping("/search")
    public IPage<Discipline> getDisciplineListByCIdAnd(Long id,String date,String type,String studentName){
        LocalDateTime ldt = null;
        if(StringUtils.isNotEmpty(date)){
            DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ld = LocalDate.parse(date,df);
            ldt = ld.atStartOfDay();
        }
        return studentService.findDisciplineByCondition(id,ldt,studentName,type,1);
    }

    @RequestMapping("/find")
    public Discipline getDisciplineById(Long id){
        return studentService.findDisciplineById(id);
    }

    @RequestMapping("/edit")
    public Boolean editDisciplineById(Discipline discipline){
        return studentService.editDiscipline(discipline);
    }

    @RequestMapping("/create")
    public Boolean createStudent(Discipline discipline){

        return studentService.createDiscipline(discipline);
    }

    @RequestMapping("/remove")
    public Boolean removeStudent(Long id){

        return studentService.removeDisciplineById(id);
    }
    @RequestMapping("/removeBatch")
    public Boolean removeBatchStudent(@RequestParam(value = "ids[]") List<Long> ids){
        return studentService.removeDisciplineByIds(ids);
    }

    @RequestMapping("/downLoad")
    public String exportExcelTest(HttpServletResponse response, String type, String excel, String sheet, String excelName, Long cid) throws ClassNotFoundException {
        List<Discipline> list = studentService.findDisciplineByCId(cid);
        UpDownUtil.exportExcel(response,type,list,excel,sheet,excelName);
        return "success";
    }
}
