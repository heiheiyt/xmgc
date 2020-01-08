package com.gem.xmgc.web;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import com.gem.xmgc.util.UpDownUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张开
 * @date 2019/10/31 18:50
 */
@Controller
@EnableTransactionManagement
@RequestMapping("/xmgclist")
public class XmgcManagerItemsController {
    @Autowired
    SubjectTypeMapper subjectTypeMapper;
    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ScoreMapper scoreMapper;
    @Autowired
    SubjectCheckMapper subjectCheckMapper;
    /**
    * @author 张开
    * @date 2019/10/31 19:55
    * @description 查询所有学科方向
    */
    @GetMapping("/AllSubject")
    @ResponseBody
    public List<SubjectType> AllSubject(String year){
        System.out.println(year);
        QueryWrapper<Clazz> wrapper = Wrappers.<Clazz>query().eq("start_year",year).groupBy("type_id");
        List<Clazz> lists = clazzMapper.selectList(wrapper);
        ArrayList<Long> typeids = new ArrayList<>();
        for(Clazz z:lists){
            typeids.add(z.getTypeId());
        }
        System.out.println(typeids);
        QueryWrapper<SubjectType> wrapper1 = Wrappers.<SubjectType>query().in("id",typeids);
        List<SubjectType> list = subjectTypeMapper.selectList(wrapper1);
        System.out.println(list);
        return list;
    }

    /**
    * @author 张开
    * @date 2019/11/1 9:09
    * @description  查询开放学科的所有年份
    */
    @GetMapping("/AllYear")
    @ResponseBody
    public List<Clazz> AllYear(){
        List<Clazz> list=clazzMapper.selectyears();
        System.out.println(list);
        return list;
    }

    /**
     * @author 张开
     * @date 2019/11/1 9:09
     * @description  通过年份,学科 ,查询班级
     */
    @GetMapping("/AllClazz")
    @ResponseBody
    public List<Clazz> AllClazz(String year,String subject){
        System.out.println(subject);
        QueryWrapper<Clazz> wrapper1 = Wrappers.<Clazz>query().eq(StringUtils.isNotEmpty(subject),"type_id",subject).eq("start_year",year);
        List<Clazz> list1=clazzMapper.selectList(wrapper1);
        System.out.println(list1);
        return list1;
    }


    /**
     * @author 张开
     * @date 2019/11/1 9:09
     * @description  通过班级id得到所有学生
     */
    @PostMapping("/allStudents/one")
    @ResponseBody
    public IPage<Student> allStudents(Integer current,String clazz){
        Page<Student> page = new Page<>(current,5);
        QueryWrapper<Student> wrapper = Wrappers.<Student>query().eq("c_id",clazz);
       return studentMapper.selectPage(page,wrapper);
    }



    /**
     * @author 张开
     * @date 2019/11/1 9:09
     * @description  通过学生id查询所有成绩
     */
    @GetMapping("/grades/{id}")
    public String grades(Model model, @PathVariable("id") Long id){
        System.out.println(id);
        QueryWrapper<Score> wrapper = Wrappers.<Score>query().eq("s_id",id);
        List<Score> list = scoreMapper.selectList(wrapper);
        System.out.println(list);
        for(Score s:list){
            //拿到userpaperId
            Long uid = s.getUId();
            String pname = scoreMapper.selectPNameByPId(uid);
            s.setPname(pname);
        }
        model.addAttribute("grades",list);
        return "xmgcmanager/detail_score";
    }


    /**
     * @author 张开
     * @date 2019/11/1 9:09
     * @description  通过班级id得到所有学生的subjectcheck表数据
     */
    @PostMapping("/AllAnsProject/one")
    @ResponseBody
    public IPage<SubjectCheck> AllAnsProject(Integer current, String clazz){
        Page<SubjectCheck> page = new Page<>(current,5);
        return subjectCheckMapper.selectAllAnsProjectPage(page,clazz);
    }

    /**
     * @author 张开
     * @date 2019/11/1 9:09
     * @description  通过班级id得到所有学生的subjectcheck表数据
     */
    @GetMapping("/ansProjectChange/{id}")
    public String ansProjectChange(Model model ,@PathVariable("id") int id){
        System.out.println(id);
        QueryWrapper<SubjectCheck> wrapper = Wrappers.<SubjectCheck>query().eq("id",id);
        SubjectCheck subjectCheck  = subjectCheckMapper.selectOne(wrapper);
        model.addAttribute("subjectCheck",subjectCheck);
        return "/xmgcmanager/ansProject_change";
    }


    /**
     * @author 张开
     * @date 2019/11/1 9:09
     * @description  修改答辩项目(项目名称,线上,线下)
     */
    @PostMapping("/ansProjectChange")
    @ResponseBody
    public String ansProjectchange(int subjectCheckId,String subjectName,String onlineCheck,String underCheck ){
        System.out.println(subjectCheckId+"..."+subjectName+"..."+onlineCheck+"..."+underCheck);

        SubjectCheck subjectCheck = new SubjectCheck();
        subjectCheck.setSubjectName(subjectName);
        if(onlineCheck.equals("提交")){
            subjectCheck.setOnlineCheck(Submission.SUBMISSION);
        }else{
            subjectCheck.setOnlineCheck(Submission.NOT_SUBMOTTED);
        }

        if("通过".equals(underCheck)){
            subjectCheck.setUnderCheck(Pass.PASS);
        }else{
            subjectCheck.setUnderCheck(Pass.FAIL);
        }
        QueryWrapper<SubjectCheck> wrapper = Wrappers.<SubjectCheck>query().eq("id",subjectCheckId);
        subjectCheckMapper.update(subjectCheck,wrapper);
        return "1";
    }

    @GetMapping("/downLoad")
    @ResponseBody
    public String downLoad(HttpServletRequest request ,HttpServletResponse response) throws IOException{
        try {
            String clazz = request.getParameter("clazz");
            List<SubjectCheck> list =  subjectCheckMapper.selectAllAnsProject(clazz);
            UpDownUtil.exportExcel(response,"SubjectCheck",list,"学生最终考核成绩","学生成绩","student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "1";
    }


}
