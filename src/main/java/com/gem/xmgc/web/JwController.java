package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.service.ClazzServiceImpl;
import com.gem.xmgc.service.QuestionPageService;
import com.gem.xmgc.service.RecruitStudentTestService;
import com.gem.xmgc.service.SubjectTypeService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName JwController
 * @Description: TODO
 * @Author zy
 * @Date 2019/10/26
 * @Version V1.0
 **/
@RestController
@Transactional
public class JwController {
    @Autowired
    SubjectTypeService subjectTypeService;
    @PostMapping("/modual/{current}")
    public IPage<FirstLevel> modual(@PathVariable("current")Integer current){
        IPage<FirstLevel> firstLevels= subjectTypeService.findFirstAll(current,null);
        System.out.println(current);
        return firstLevels;
    }
    @PostMapping("/modualBysubject")
    public IPage<FirstLevel> modual2(Integer pageCurrent,String subjectName){
        System.out.println(subjectName);
        if (!subjectName.equals("请选择学科")){
       IPage<FirstLevel>firstLevelIPage=subjectTypeService.
                findFirstAll(pageCurrent,subjectTypeServiceImpl.
                        findSubjectByName(subjectName).
                        getId());
        firstLevelIPage.getRecords().forEach(System.out::println);
        System.out.println(pageCurrent);
        System.out.println(firstLevelIPage.getPages());
        return firstLevelIPage;
        }else {

            return subjectTypeService.findFirstAll(pageCurrent,null);
        }
    }
    @Autowired
    SubjectTypeService subjectTypeServiceImpl;
    @GetMapping("/subject")
    public List<SubjectType> subject(){
        return subjectTypeService.findAllSubject();
    }

    @PostMapping("/add")
    public boolean add(String subjectId,String firstLevel){
      Long id=  subjectTypeServiceImpl.findSubjectByName(subjectId).getId();
         FirstLevel firstLevel1=new FirstLevel();
         firstLevel1.setTypeId(id);
         firstLevel1.setFirstName(firstLevel);
         firstLevel1.setStatu(0L);
         return subjectTypeServiceImpl.createFirstLevel(firstLevel1);
    }
    @GetMapping("/firstLevel")
    public IPage<FirstLevel> findAllFirstLevel(Model model,String subjectType){
        Long id=  subjectTypeServiceImpl.findSubjectByName(subjectType).getId();
        model.addAttribute("id",subjectTypeServiceImpl.findSubjectById(id));
        return subjectTypeServiceImpl.findFirstLevelAll(id,1);
    }
    @PostMapping("/modualUpdate")
    public boolean modualUpdate(String username,String subjectType,Long firstLevelId){
        FirstLevel firstLevel1=new FirstLevel();
        firstLevel1.setFirstName(username);
        Long cid=  subjectTypeServiceImpl.findSubjectByName(subjectType).getId();
        firstLevel1.setTypeId(cid);
        firstLevel1.setId(firstLevelId);
        firstLevel1.setStatu(0L);
        return subjectTypeServiceImpl.editFirstLevel(firstLevel1);
    }
    @PostMapping("/remove/{id}")
    public boolean findAllFirstLevel(@PathVariable("id") Long id){
        return subjectTypeServiceImpl.removeFirstLevelById(id);
    }
    @PostMapping("/subjectTest/{current}")
    public IPage<SubjectContent> subjectTest(@PathVariable("current") Integer current){
        System.out.println(current);
        return subjectTypeServiceImpl.findSubjectTestBySubject(current);
    }
    @PostMapping("/findSubjectTestBySubjects")
    public IPage<SubjectContent> findSubjectTestBySubjects(Integer pageCurrent){
        return subjectTypeServiceImpl.findSubjectTestBySubject(pageCurrent);
    }
    @PostMapping("/findSubjectTestBySubject")
    public IPage<SubjectContent> findSubjectTestBySubject(Integer pageCurrent,String subjectName){
        if (!subjectName.equals("请选择学科")){
            SubjectType subjectType=subjectTypeServiceImpl.findSubjectByName(subjectName);
        return subjectTypeServiceImpl.findSubjectTestBySubjectId(subjectType.getId(),pageCurrent);
        }else{
            return subjectTypeServiceImpl.findSubjectTestBySubject(pageCurrent);
        }
    }
    @GetMapping("/allSubject")
    public IPage<FirstLevel>  allSubject(){
        return subjectTypeServiceImpl.findFirstLevelAll(null,1);
    }
   @Autowired
    QuestionPageService questionPageService;
    @PostMapping("/wenJuanPlan")
    public IPage<SearchPaperType> wenJuanPlan(){
        return questionPageService.findAllQuestionPage(1);
    }
    @PostMapping("/wenJuanInfos")
    public IPage<SearchPaperType> wenJuanInfo(Integer pageCurrent){
        return questionPageService.findAllQuestionPage(pageCurrent);
    }
    @PostMapping("/wenJuanPlanRemove")
    public boolean wenJuanPlanRemove(Long id){
        return questionPageService.removeQuestionPage(id);
    }


    @GetMapping("/allSecondLevel")
    public IPage<SecondLevel>  allSecondLevel(String firstLevel){
        return subjectTypeServiceImpl.findSecondAll(subjectTypeServiceImpl.findFirstLevelByName(firstLevel).getId(),1);
    }
    @PostMapping("/removeSecond/{id}")
    public boolean removeSecond(@PathVariable("id") Long secondLevelId){
        return subjectTypeServiceImpl.removeSecondLevelById(secondLevelId);
    }
    @PostMapping("/allSecondLevel")
    public IPage<SecondLevel> allSecondLevel(Integer pageCurrent, String subjectName){

        return  subjectTypeServiceImpl
                .findSecondAll(subjectTypeServiceImpl
                .findFirstLevelByName(subjectName).getId(),pageCurrent);
    }
    @PostMapping("/wenJuanInfo")
    public IPage<SearchItem> wenJuanInfo(String name){
        return questionPageService.fingQuestionitem(name,1);
    }
    @PostMapping("/wenJuanInfoByPage")
    public IPage<SearchItem> wenJuanInfoByPage(String subjectName,Integer pageCurrent){
        return questionPageService.fingQuestionitem(subjectName,pageCurrent);
    }
    @PostMapping("/updateQuestion/{id}")
    public boolean updateQuestion(@PathVariable("id")Long id,String question,String selectA,String selectB,String selectC,String selectD){
        SearchItem searchItem=new SearchItem();
        searchItem.setId(id);
        searchItem.setQuestion(question);
        searchItem.setSelectA(selectA);
        searchItem.setSelectB(selectB);
        searchItem.setSelectC(selectC);
        searchItem.setSelectD(selectD);
        questionPageService.updateQuestion(searchItem);
        return true;
    }
    @PostMapping("/questionRemove/{id}")
    public boolean questionRemove(@PathVariable("id") Long questionId){
        return questionPageService.removeQuestionItem(questionId);
    }
    @Autowired
    RecruitStudentTestService recruitStudentTestService;
    @PostMapping("/RecruitInfo")
    public IPage<UseRecruit> RecruitInfo(){
       return recruitStudentTestService.findAllRecruitStudentTest(1);
    }
    @PostMapping("/addRecruit")
    public Boolean addRecruit(Long recruit,String startTime,String endTime,String RecruitName){
        DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startTime,df);
        LocalDateTime startTimes = start.atStartOfDay();
        LocalDate end = LocalDate.parse(endTime,df);
        LocalDateTime endTimes = end.atStartOfDay();
        UseRecruit useRecruit=new UseRecruit();
        useRecruit.setEndDate(endTimes);
        useRecruit.setStatu(0);
        useRecruit.setStartDate(startTimes);
        useRecruit.setUserecruitName(RecruitName);
        useRecruit.setRecruitinfoId(recruitStudentTestService.findAllRecruitInfoById(recruit).getId());
        return  recruitStudentTestService.createUseRecruit(useRecruit);
    }

    @GetMapping("/findUseRecruit/{id}")
    public UseRecruit findUseRecruit(@PathVariable("id")Long id){
        return  recruitStudentTestService.findAllRecruitStudentTestById(id);
    }

    @PostMapping("/addRecruits")
    public boolean addRecruits(Long useRecruitId,Long recruit,String startTime,String endTime,String RecruitName){
        UseRecruit useRecruit=new UseRecruit();
        useRecruit.setRecruitinfoId(recruit);
        useRecruit.setUserecruitName(RecruitName);
        DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startTime,df);
        LocalDateTime startTimes = start.atStartOfDay();
        LocalDate end = LocalDate.parse(endTime,df);
        LocalDateTime endTimes = end.atStartOfDay();
        useRecruit.setStartDate(startTimes);
        useRecruit.setEndDate(endTimes);
        useRecruit.setId(useRecruitId);
        return recruitStudentTestService.editRecruitStudentTest(useRecruit);
    }
    @Autowired
    ClazzServiceImpl clazzService;
    @PostMapping("/classInfo")
    public IPage<Clazz> classInfo(){
        return clazzService.findAllClazz(1);
    }
    @PostMapping("/clazz/{id}")
    public IPage<Clazz> clazz(@PathVariable("id")Integer pageCurrent,String subject,String year){
        if ("请选择学科".equals(subject)&&year==""){
            return clazzService.findAllClazz(pageCurrent);
        }else if (!"请选择学科".equals(subject)&&year!=""){
            return clazzService.findAllClazzBy(year,pageCurrent,subject);
        }else if ("请选择学科".equals(subject)|year!=""){
            return clazzService.findAllClazzByYear(pageCurrent,year);
        }else {
            return clazzService.findAllClazzBySubject(pageCurrent,subject);
        }
    }
    @PostMapping("/searchClazz")
    public IPage<Clazz> searchClazz(String subjectName,String time){
        if (!"请选择学科".equals(subjectName)&& time!=""){
            return clazzService.findAllClazzBy(time,1,subjectName);
        }else if ("请选择学科".equals(subjectName)&&time!=""){
            return clazzService.findAllClazzByYear(1,time);
        }else {
            return clazzService.findAllClazzBySubject(1,subjectName);
        }
    }
    @PostMapping("/tName")
    public List<Teacher> tName(){
        return clazzService.findAllTeacher();
    }
    @PostMapping("/mName")
    public List<Manage> mName(){
        return clazzService.findAllManager();
    }
    @PostMapping("/addClazz")
    public boolean addClazz(Long subjectName,String clazzName,String startTime,String year,String endTime,Long tName,Long mName){
        Clazz clazz=new Clazz();
        clazz.setTypeId(subjectName);
        clazz.setUpTime(LocalDateTime.now());
        clazz.setStartYear(year);
        DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startTime,df);
        LocalDateTime startTimes = start.atStartOfDay();
        LocalDate add = LocalDate.parse(endTime,df);
        LocalDateTime addTimes = add.atStartOfDay();
        clazz.setStaatDate(addTimes);
        clazz.setAddTime(startTimes);
        clazz.setMId(mName);
        clazz.setTId(tName);
        clazz.setCId(clazzName);
        return clazzService.createClazz(clazz);
    }
    @PostMapping("/updateClazz")
    public boolean updateClazz(Long subjectName,String clazzName,String startTime,String year,String endTime,Long tName,Long mName){
        Clazz clazz=new Clazz();
        clazz.setTypeId(subjectName);
        clazz.setUpTime(LocalDateTime.now());
        clazz.setStartYear(year);
        DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startTime,df);
        LocalDateTime startTimes = start.atStartOfDay();
        LocalDate add = LocalDate.parse(endTime,df);
        LocalDateTime addTimes = add.atStartOfDay();
        clazz.setStaatDate(addTimes);
        clazz.setAddTime(startTimes);
        clazz.setMId(mName);
        clazz.setTId(tName);
        clazz.setCId(clazzName);
        return clazzService.createClazz(clazz);
    }
    @PostMapping("/removeClazz/{id}")
    public Boolean removeClazz(@PathVariable("id")Long id){
        return clazzService.removeClazz(id);
    }

    @PostMapping("/firstLevels/{id}")
    public List<FirstLevel> firstLevels(@PathVariable("id") Long id){
        return subjectTypeServiceImpl.findFirstLevelAllBySubject(id) ;
    }
    @PostMapping("/second/{id}")
    public IPage<SecondLevel> secondLevels(@PathVariable("id") Long id){
        return subjectTypeServiceImpl.findSecondAll(id,1) ;
    }
    @PostMapping("/allSecondLevels")
    public IPage<SecondLevel> allSecondLevel(){
        return subjectTypeServiceImpl.findAllSecondLevel(1) ;
    }

    @PostMapping("/addSecond")
    public boolean addSecond(Long province,String username){
        return subjectTypeServiceImpl.createSecondLevel(province,username);
    }
    @PostMapping("/pageFirstLevel/{id}")
    public IPage<SecondLevel> pageFirstLevel(@PathVariable("id") Integer id){
        return subjectTypeServiceImpl.findAllSecondLevel(id);
    }
    @PostMapping("/pageFirstLevel")
    public IPage<SecondLevel> pageFirstLevels(Integer pageCurrent,Long subjectName){
        return subjectTypeServiceImpl.findSecondAll(subjectName,pageCurrent) ;
    }
    @PostMapping("/updateSecond")
    public Boolean updateSecond(Long secondLevelId,String username,Long province,Long subjectType){
        SecondLevel secondLevel=new SecondLevel();
        secondLevel.setId(secondLevelId);
        secondLevel.setStatu(0);
        secondLevel.setSName(username);
        secondLevel.setFId(province);
        return subjectTypeServiceImpl.editSecondtLevel(secondLevel);
    }
    @PostMapping("/removeSecondLevel/{id}")
    public boolean removeSecond(@PathVariable("id") Integer id){
        return subjectTypeServiceImpl.removeSecondLevelById(id);
    }
    @PostMapping("/testType")
    public List<TestType> testType(){
        return subjectTypeServiceImpl.findTestType();
    }
    @PostMapping("/secondLevels/{id}")
    public List<SecondLevel> secondLS(@PathVariable("id") Long id){
        return subjectTypeServiceImpl.findSecond(id) ;
    }

    @PostMapping("/addSubjectTest")
        public boolean addSubjectTest(Long username,Long testType,Long secondLevels,Long subject){
        SubjectContent subjectContent=new SubjectContent();
        subjectContent.setSubjectid(subject);
        subjectContent.setType(testType);
        subjectContent.setThing(username);
        subjectContent.setStatu(0);
        SubjectContentDetail subjectContentDetail=new SubjectContentDetail();
        subjectContentDetail.setContent(secondLevels);
        subjectContentDetail.setStatu(0);
        return  subjectTypeServiceImpl.createSubjectTest(subjectContent,subjectContentDetail);
    }
    @PostMapping("/updateSubjectTest")
    public boolean updateSubjectTest(Long subjectTestId,Long username,Long testType,Long secondLevels,Long subject){
        SubjectContent subjectContent=new SubjectContent();
        subjectContent.setSubjectid(subject);
        subjectContent.setType(testType);
        subjectContent.setThing(username);
        subjectContent.setStatu(0);
        subjectContent.setId(subjectTestId);
        SubjectContentDetail subjectContentDetail=new SubjectContentDetail();
        subjectContentDetail.setContent(secondLevels);
        subjectContentDetail.setStatu(0);
        return  subjectTypeServiceImpl.createSubjectTest(subjectContent,subjectContentDetail);
    }
    @PostMapping("/deleteSubjectTest/{subjectTestId}")
    public boolean deleteSubjectTest(@PathVariable("subjectTestId")Long subjectTestId){
        subjectTypeServiceImpl
                .removeSubjectTestDetailById(subjectTypeServiceImpl
                .findSubjectTestDetailById(subjectTypeServiceImpl
                        .findSubjectTestById(subjectTestId)
                        .getId()).getId());
    return subjectTypeServiceImpl.removeSubjectTest(subjectTestId);
    }
    @PostMapping("/findClazz/{id}")
    public List<Clazz> clazz(@PathVariable("id")Long id){
        return clazzService.foundAllClazz(id);
    }
    @PostMapping("/allClazzTestPlan")
    public IPage<ClassDetail> allClazzTestPlan(){
        return clazzService.findAllClassTests(1);
    }

    @PostMapping("/findClazzByClazz/{id}")
    public IPage<ClassDetail> findClazzByClazz(@PathVariable("id")Long id){
        return clazzService.findAllClassTestsByClazz(1,id);
    }
    @PostMapping("/findClazzByClazzPage")
    public IPage<ClassDetail> findClazzByClazzPage(Integer pageCurrent,Long subjectName){
        if(subjectName==null){
            return clazzService.findAllClassTests(pageCurrent);
        }else{
        return clazzService.findAllClassTestsByClazz(pageCurrent,subjectName);
        }
    }
    @PostMapping("/testNumber")
    public List<SubjectContent> testNumber(){
        return subjectTypeServiceImpl.findAllSubjectTest();
    }
    @PostMapping("/addTestPlan")
    public boolean addTestPlan(Long subject,Long clazz,Long testPlanNumber,String start){
        NewClassDetail newClassDetail=new NewClassDetail();
        newClassDetail.setCid(clazz);
        DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start,df);
        LocalDateTime startTimes = startDate.atStartOfDay();
        newClassDetail.setDate(startTimes);
        newClassDetail.setThing(testPlanNumber);
        return clazzService.createClassTest(newClassDetail);
    }
    @PostMapping("/deleteClazzTest/{id}")
    public boolean deleteClazzTest(@PathVariable("id")Long id){
        return clazzService.removeClassTest(id);
    }
    @PostMapping("/questions")
    public List<SearchPaperType> questions(){
        return questionPageService.searchAllPaperType();
    }

    @PostMapping("/addQuestion")
    public boolean addQuestion(Long statu,Long clazz,String start,Long province){
        SearchUseInfo searchUseInfo=new SearchUseInfo();
        searchUseInfo.setCid(clazz);
        searchUseInfo.setSid(province);
        DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start,df);
        LocalDateTime startTimes = startDate.atStartOfDay();
        searchUseInfo.setUsedate(startTimes);
        searchUseInfo.setFlag(statu);
        searchUseInfo.setStatu(0);
        return questionPageService.createQuestionPage(searchUseInfo);
    }
    @PostMapping("/releaseQuestion")
    public List<SearchPaperStatu> releaseQuestion(){
        return questionPageService.searchPaperStatu();
    }
    @PostMapping("/updateQuestionnaires")
    public boolean updateQuestionnaires(Long statu,Long clazz,String start,Long province){
        SearchUseInfo searchUseInfo=new SearchUseInfo();
        searchUseInfo.setCid(clazz);
        searchUseInfo.setSid(province);
        DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start,df);
        LocalDateTime startTimes = startDate.atStartOfDay();
        searchUseInfo.setUsedate(startTimes);
        searchUseInfo.setFlag(statu);
        searchUseInfo.setStatu(0);
        return questionPageService.editQuestionPage(searchUseInfo);
    }
    @PostMapping("/allClassInfo")
    public IPage<Clazz> allClassInfo(){
        return clazzService.findAllClazzinfo(1);
    }
    @PostMapping("/upLoadExcel")
    public String upLoadExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        InputStream inputStream=file.getInputStream();
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        String name=file.getOriginalFilename();
        String partten="(UI|JD|AI|H5)";
        Pattern r=Pattern.compile(partten);
        Matcher matcher=r.matcher(name);
        String subject=null;
        String result=null;
        if (matcher.find()) {
            subject=matcher.group(0);
        }
        String[] numbers = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
        for (int n = 0; n < workbook.getNumberOfSheets(); n++) {
            XSSFSheet sheet = workbook.getSheetAt(n);
            int sheetLength = sheet.getLastRowNum();
            result=(numbers[n]);
            int rowNum = sheet.getLastRowNum();
            SearchPaperType searchPaperType=new SearchPaperType();
            searchPaperType.setTName("第"+result+"次满意度调查问卷-"+subject);
            searchPaperType.setPs("亲爱的同学，你好！<br/>感谢你抽出时间参与我们的调查，请根据自己的实际感受和看法如实填写。<br/>本次调查为不记名调查，答案无对错之分，旨在了解学员在高博学习、生活期间的满意度以及不满意原因，以帮助我们及时发现问题、纠正偏差，同时也为大家营造一个更好的生活、学习环境，提高学习效率！");
            questionPageService.addQuestion(searchPaperType);
            for (int i = 1; i <= rowNum-1; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    row = sheet.createRow(i);
                }
                SearchItem searchItem = new SearchItem();
                searchItem.setQuestion(String.valueOf(row.getCell(1)));
                searchItem.setSelectA(String.valueOf(row.getCell(2)));
                searchItem.setSelectB(String.valueOf(row.getCell(3)));
                searchItem.setSelectC(String.valueOf(row.getCell(4)));
                searchItem.setStatu(0);
                searchItem.setSelectD(String.valueOf(row.getCell(5)));
                System.out.println(row.getCell(6));
                if (row.getCell(6)!=null){
                searchItem.setType(clazzService.searchTypeId(String.valueOf(row.getCell(6))));
                    questionPageService.editQuestionItems(searchItem);
                    SearchPaperDetail searchPaperDetail=new SearchPaperDetail();
                    searchPaperDetail.setPaperId(searchPaperType.getId());
                    searchPaperDetail.setQId(searchItem.getId());
                    searchPaperDetail.setStatu(0);
                    questionPageService.editQuestiondetaill(searchPaperDetail);
                }
            }
        }
        return "1234";
    }
    @GetMapping("/RecruitBypage")
    public IPage<UseRecruit> RecruitBypage(Integer pageCurrent){
        return recruitStudentTestService.findAllRecruitStudentTest(pageCurrent);
    }

    @PostMapping("RecruitTest")
    public List<RecruitInfo> RecruitTest(){
        return  recruitStudentTestService.findAllRecruitInfo();
    }
    @PostMapping("RecruitTestBySubject")
    public List<RecruitInfo> RecruitTestBySubject(Long subject){
        String type=null;
        if (subject==1){
            type="JD";
        }else if (subject==2) {
            type="H5";
        }else if (subject==4){
            type="UI";
        }else if (subject==6){
            type="AI";
        }
        if (type!=null){
            return  recruitStudentTestService.findAllRecruitInfoBy(type);
        }else {
            return recruitStudentTestService.findAllRecruitInfo();
        }
    }
    @PostMapping("/recruitTestInfos/{id}")
    public IPage<RecruitDetail> recruitTestInfos(@PathVariable("id") Long id){
        return recruitStudentTestService.findRecruitStudentItemByName(1,id);
    }
    @PostMapping("/recruitTestInfoBypage")
    public IPage<RecruitDetail> recruitTestInfoBypage(Integer pageCurrent,Long subjectName){
        return recruitStudentTestService.findRecruitStudentItemByName(pageCurrent,subjectName);
    }
    @PostMapping("/upLoadRecruitExcel")
    public int upLoadRecruitExcel(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream=file.getInputStream();
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        String name=file.getOriginalFilename();
        RecruitInfo recruitInfo=new RecruitInfo();
        recruitInfo.setRName(name);
        recruitInfo.setStatu(0);
        recruitStudentTestService.createRecruitStudentItem(recruitInfo);
        for (int i=0;i<workbook.getNumberOfSheets();i++){
            Sheet sheet=workbook.getSheetAt(i);
            System.out.println(sheet.getLastRowNum());
            for (int a=0;a<sheet.getLastRowNum()-1;a++){
                Row row=sheet.getRow(a);
                if (row == null) {
                    row = sheet.createRow(a);
                }
                RecruitDetail recruitDetail=new RecruitDetail();
                if (row.getCell(1)!=null){
                    recruitDetail.setRId(recruitInfo.getId());
                    recruitDetail.setStatu(0);
                    recruitDetail.setQuestion(String.valueOf(row.getCell(1)));
                    recruitDetail.setA(String.valueOf(row.getCell(2)));
                    recruitDetail.setB(String.valueOf(row.getCell(3)));
                    recruitDetail.setC(String.valueOf(row.getCell(4)));
                    recruitDetail.setD(String.valueOf(row.getCell(5)));
                    recruitDetail.setAnswer(String.valueOf(row.getCell(6)));
                    recruitStudentTestService.uploadRecruitStudentItem(recruitDetail);
                }
            }
        }

        return 123;
    }
    @PostMapping("/updateRecruitTest/{id}")
    public int updateRecruitTest(@PathVariable("id")Long id,String question,String selectA,String selectB,String selectC,String selectD,String answer){
        RecruitDetail recruitDetail=new RecruitDetail();
        recruitDetail.setId(id);
        recruitDetail.setA(selectA);
        recruitDetail.setAnswer(answer);
        recruitDetail.setB(selectB);
        recruitDetail.setC(selectC);
        recruitDetail.setD(selectD);
        recruitDetail.setQuestion(question);
        return recruitStudentTestService.editRecruitDetail(recruitDetail);
    }
    @PostMapping("/deleteTest/{id}")
    public boolean deleteTest(@PathVariable("id")Long id){
        return recruitStudentTestService.recruitStudentItemById(id);
    }








    @GetMapping("/crm")
    public List<Integer> crm(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","GET");
        System.out.println("遭遇未知袭击!!!!!!");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        return list;
    }
}

