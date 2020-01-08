package com.gem.xmgc.web;

import com.gem.xmgc.entity.FirstLevel;
import com.gem.xmgc.service.ClazzServiceImpl;
import com.gem.xmgc.service.QuestionPageService;
import com.gem.xmgc.service.RecruitStudentTestService;
import com.gem.xmgc.service.SubjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName WebController
 * @Description: TODO
 * @Author zy
 * @Date 2019/10/28
 * @Version V1.0
 **/
@Controller
@Transactional
public class JwWebController {
    @Autowired
    SubjectTypeService subjectTypeServiceImpl;
    @RequestMapping("/addTest")
    public String module(){
        return "jw/addTest";
    }
    @RequestMapping("/addClassTestPlan")
    public String addClassTestPlan(){
        return "jw/addClassTestPlan";
    }
    @RequestMapping("/addSecondTest")
    public String addSecondTest(){
        return "jw/addSecondTest";
    }
    @RequestMapping("/ModualUpdate/{id}")
    public String ModualUpdate(Model model, @PathVariable("id") Long id){
        FirstLevel firstLevel=subjectTypeServiceImpl.findFirstAllById(id);
        model.addAttribute("firstLevel",firstLevel);
        model.addAttribute("subjectType",subjectTypeServiceImpl
               .findSubjectById(firstLevel.getId()));
        return "jw/ModualUpdate";
    }
    @RequestMapping("/SubjectTestPlan")
    public String SubjectTestPlan(){
        return "jw/SubjectTestPlan";
    }
    @RequestMapping("/addTestPlan")
    public String addTestPlan(){
        return "jw/addTestPlan";
    }
    @RequestMapping("/ClassTestPlan")
    public String ClassTestPlan(){
        return "jw/ClassTestPlan";
    }
    @RequestMapping("/wenJuan")
    public String wenJuan(){
        return "jw/wenjuan";
    }
    @Autowired
    QuestionPageService questionPageService;
    @RequestMapping("/questionsubject")
    public String questionsubject(Model model,String name){
        System.out.println(questionPageService.searchPaperTypeByName(name));
        model.addAttribute("questionsName", questionPageService.searchPaperTypeByName(name));
        return "jw/questionsubject";
    }
    @RequestMapping("/updateQuestionnaire/{id}")
    public String updateQuestionnaire(Model model,@PathVariable("id") Long id){
        questionPageService.findQuestionPageById(id);
        model.addAttribute("questionId",questionPageService.searchPaperStatuById(questionPageService.findQuestionPageById(id).getFlag()));
        model.addAttribute("question",questionPageService.findQuestionPageById(id));
        model.addAttribute("clazz",clazzService.findAllClazzById(questionPageService.findQuestionPageById(id).getCid())
        .getCId());
        model.addAttribute("questionName",questionPageService.findQuestionPageInfoById(questionPageService.findQuestionPageById(id).getSid()));
        return "jw/updateQuestionnaire";
    }

    @RequestMapping("/UpdateTestPlan/{id}")
    public String UpdateTestPlan(Model model,@PathVariable("id") Long id){
       model.addAttribute("subjectTest",subjectTypeServiceImpl.findSubjectTestById(id));
       model.addAttribute("subjectTestDetail",subjectTypeServiceImpl.
               findSubjectTestDetailById(subjectTypeServiceImpl.findSubjectTestById(id).getId()));
       return "jw/UpdateTestPlan";
    }
    @RequestMapping("/secondLevelInfo/{id}")
    public String firstLevel(Model model,@PathVariable("id")Long id){
        model.addAttribute("secondLevel",subjectTypeServiceImpl.findSecondAll(id,1));
        model.addAttribute("firstId",subjectTypeServiceImpl.findFirstAllById(id));
        return "jw/firstLevel";
    }
    @RequestMapping("/SecondModualUpdate")
    public String SecondModualUpdate(){

        return "jw/SecondModualUpdate";
    }
    @RequestMapping("/QuestionUpdate/{id}")
    public String QuestionUpdate(Model model,@PathVariable("id")Long id){
       model.addAttribute("question",questionPageService.fingQuestionitemById(id));
        return "jw/QuestionUpdate";
    }

    @RequestMapping("/recruitAdd")
    public String recruitAdd(){
        return "jw/recruitAdd";
    }
    @RequestMapping("/Recruit")
    public String Recruit(){
        return "jw/Recruit";
    }
    @Autowired
    RecruitStudentTestService recruitStudentTestService;
    @RequestMapping("/updateRecruit/{id}")
    public String updateRecruit(Model model,@PathVariable("id")Long id){
        model.addAttribute("UseRecruit",recruitStudentTestService.findAllRecruitStudentTestById(id));
        return "jw/updateRecruit";
    }
    @RequestMapping("/addQuestionnaire")
    public String addQuestionnaire(){
        return "jw/addQuestionnaire";
    }

    @RequestMapping("/UpdateQuestionTest")
    public String UpdateQuestionTest(){
        return "jw/UpdateQuestionTest";
    }

    @RequestMapping("/ClassManager")
    public String ClassManager(){
        return "jw/ClassManager";
    }

    @RequestMapping("/ClassAdd")
    public String ClassAdd(){
        return "jw/ClassAdd";
    }
    @Autowired
    ClazzServiceImpl clazzService;
    @RequestMapping("/ClassChange/{id}")
    public String ClassChange(Model model,@PathVariable("id")Long id){
        model.addAttribute("clazz",clazzService.findAllClazzById(id));
        return "jw/Class_change";
    }
    @RequestMapping("/SecondModualUpdate/{id}")
    public String SecondModualUpdate(Model model,@PathVariable("id")Long id){
        model.addAttribute("secondLevel",subjectTypeServiceImpl.findSecondById(id));
        return "jw/SecondModualUpdate";
    }
    @RequestMapping("/updateClassTestPlan/{id}")
    public String updateClassTestPlan(Model model,@PathVariable("id")Long id){
        model.addAttribute("ClassDetail",clazzService.findClassTestById(id));
        return "jw/updateClassTestPlan";
    }
    @RequestMapping("/recruitQuestionUpdate")
    public String recruitQuestionUpdate(Model model,Long name){
        model.addAttribute("recruitDetail",recruitStudentTestService.findRecruitDetailById(name));
        return "jw/recruitQuestionUpdate";
    }






}

