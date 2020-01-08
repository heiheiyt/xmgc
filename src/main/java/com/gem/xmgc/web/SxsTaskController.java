package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import com.gem.xmgc.service.PaperService;
import com.gem.xmgc.service.SubjectTypeService;
import com.gem.xmgc.service.TaskService;
import com.gem.xmgc.util.LocalDateTimeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/task")
public class SxsTaskController {
    @Autowired
    TitleListMapper titleListMapper;
    @Autowired
    PaperService paperService;
    @Autowired
    TaskService taskService;
    @Autowired
    SubjectTypeMapper subjectTypeMapper;
    @Autowired
    SubjectTypeService subjectService;
    @Autowired
    TitleTypeMapper titleTypeMapper;
    @Autowired
    TaskListMapper taskListMapper;
    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    TaskDetailMapper taskDetailMapper;

    static final String TIME="08:30:00";
    @GetMapping("/edit/{titleId}")
    public String taskListView(@PathVariable("titleId") Long titleId,Model model,HttpSession session){
        TitleList title = titleListMapper.selectById(titleId);
        session.setAttribute("titleId",titleId);
        model.addAttribute("title",title);
        return "sxs/Trainer-taskedit";
    }
    @ResponseBody
    @PostMapping("/upLoad")
    public void fileload(@RequestParam(value = "file_data",required = false) MultipartFile file) {
        System.out.println(file.getOriginalFilename());
    }

    @ResponseBody
    @PostMapping("/toEdit")
    public int edit(HttpSession session , String question,String a,String b,String c,String d,String result ){
        TitleList titleList = new TitleList();
        Long titleId = (Long) session.getAttribute("titleId");
        if(titleId==null){
            return 0;
        }
        else{
            titleList.setId(titleId);
            titleList.setQuestion(question);
            titleList.setSelecta(a);
            titleList.setSelectb(b);
            titleList.setSelectc(c);
            titleList.setSelectd(d);
            titleList.setAnswer(result);
            System.out.println(titleList);
            return paperService.editTitleList(titleList);
        }
    }
    @ResponseBody
    @GetMapping("/view")
    public IPage<Task> taskView(Integer current,HttpSession session,String time){
        Long cid = (Long) session.getAttribute("cid");
        Long tid = (Long) session.getAttribute("tid");
        //清空session
        IPage<Task> taskIPage;
        if (current==null){
            current=1;
        }
        /**
         * 如果实训师未选班，则按照所带全部有效班级搜索，否则按班级id搜索
         */
        if (cid==null){
            taskIPage = taskService.findAllTaskByTeacherId(tid,time,null,current);
        }else{
            taskIPage = taskService.findAllTaskByClassId(cid,time,null,current);
        }
        return taskIPage;
    }
    @GetMapping("/detail/{taskId}")
    public String taskDetail(@PathVariable("taskId") Long taskId,Model model,HttpSession session ){
        session.setAttribute("taskId",taskId);
        List<TaskList> taskList = taskService.findAllTaskByTid(taskId);
        model.addAttribute("taskList",taskList);
        /**
         * 数据正确！
         */
        return "sxs/Trainer-taskdetail";
    }
    @GetMapping("/list/{taskListId}")
    public String taskList(@PathVariable("taskListId")Long taskListId,Model model,HttpSession session){
        TaskList taskList = taskService.findTaskListById(taskListId);
        //将作业题设置到共享空间
        session.setAttribute("taskListId",taskListId);
        model.addAttribute("taskList",taskList);
        return "sxs/Trainer-tasklistedit";
    }
    @ResponseBody
    @PostMapping("/list/toEdit")
    public int taskListEdit(String question , HttpSession session){
        TaskList taskList = new TaskList();
        Long taskListId = (Long) session.getAttribute("taskListId");
        if(taskListId==null){
            return 0;
        }
        else{
            taskList.setId(taskListId);
            taskList.setQuestion(question);
            return taskService.editTaskList(taskList);
        }
    }

    @GetMapping("/changeTime/{taskId}")
    public String TaskTime(@PathVariable("taskId") Long id,HttpSession session){
        session.setAttribute("taskId",id);
        return "sxs/Trainer-tasktime";
    }

    /**
     * 修改作业时间，创建时间为第一次成立时间
     * @param endTime
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/timeEdit")
    public int TaskEdit(String endTime , HttpSession session){
        Long id = (Long) session.getAttribute("taskId");
        return taskService.editTaskTime(id,endTime);
    }

    /**
     * 学科，一级，二级模块级联
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/tasklist")
    public List<FirstLevel> subjectLevel(HttpSession session){
        Long tid = (Long) session.getAttribute("tid");
        SubjectType subjectType = subjectTypeMapper.selectSubjectByTeacherId(tid);
        session.setAttribute("subjectId",subjectType.getId());
        List<FirstLevel> firstLevels = subjectService.findFirstLevelAll(subjectType.getId());
        firstLevels.get(0).setSubjectName(subjectType.getTypeName());
        return firstLevels;
    }
    @ResponseBody
    @PostMapping("/secondLevels/{firstType}")
    public List<SecondLevel> firstLevel(@PathVariable("firstType") Long id,HttpSession session){
        session.setAttribute("firstId",id);
        List<SecondLevel> secondLevels = subjectService.findSecondLevelById(id);
        secondLevels.forEach(System.err::println);
        return secondLevels;
    }
    @RequestMapping("/byFirstLevel")
    public String taskListIPage(Model model,Long firstType,Long secondType,HttpSession session){
        /*session.setAttribute("firstType",firstType);
        session.setAttribute("secondType",secondType);
        Long fid= (Long) session.getAttribute("firstType");
        Long sid= (Long) session.getAttribute("secondType");*/
        Long subjectid= (Long) session.getAttribute("subjectId");
        List<TaskList> tasklist = taskService.findTaskListByLevel(subjectid,firstType,secondType);
        model.addAttribute("tasklist",tasklist);
        return "sxs/Trainer-div";
    }
    @ResponseBody
    @PostMapping("/uploadTask")
    public String taskUpload(HttpSession session, Long[] sets){
        Long tid = (Long) session.getAttribute("tid");
        Long cid = (Long) session.getAttribute("cid");
        if (cid==null){
            return "您还未选班级！";
        }
        Long taskId= (Long) session.getAttribute("taskId");
        if(taskId==null){
            LocalDateTime tSetTime = LocalDateTime.now();
            Clazz clazz = clazzMapper.selectById(tid);
            String task_name = clazz.getCId()+"_"+tSetTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"_Task";
            LocalDateTime tStopTime = tSetTime.plusDays(1L);
            String time = tStopTime.getYear()+"-"+(tStopTime.getMonthValue()<10?("0"+tStopTime.getMonthValue()):tStopTime.getMonthValue())+"-"+(tStopTime.getDayOfMonth()<10?("0"+tStopTime.getDayOfMonth()):tStopTime.getDayOfMonth())+" "+TIME;
            tStopTime = LocalDateTimeUtil.string2LocalDateTime(time);
            //创建作业计划
            Task task = new Task();
            //设置创建老师
            task.setTId(tid);
            //设置班级id
            task.setCId(cid);
            //设置作业名称
            task.setTaskName(task_name);
            //设置创建时间
            task.setTSetTime(tSetTime);
            //设置默认结束时间
            task.setTStopTime(tStopTime);
            //数据库存入作业
            taskMapper.insert(task);
            System.err.println("作业计划id"+task.getId());
            for (Long set : sets){
                TaskDetail taskDetail = new TaskDetail();
                taskDetail.setTId(task.getId());
                taskDetail.setTaskId(set);
                taskDetailMapper.insert(taskDetail);
            }
            return "已设置默认结束时间:"+time;
        }
        else {
            for (Long set : sets){
                TaskDetail taskDetail = new TaskDetail();
                taskDetail.setTId(taskId);
                taskDetail.setTaskId(set);
                taskDetailMapper.insert(taskDetail);
            }
            return "添加成功";

        }
    }
    @GetMapping("/upload/{taskId}")
    public String upload(@PathVariable("taskId") Long id,HttpSession session){
        session.setAttribute("taskId",id);
        return "sxs/Trainer-taskupload";
    }

    @ResponseBody
    @GetMapping("/titletype")
    public List<TitleType> titleTypes(){
        return titleTypeMapper.selectList(null);
    }
    /**
     * 确认添加题目
     * @param question
     * @return
     */
    @ResponseBody
    @PostMapping("/list/add")
    public int taskadd(HttpSession session,String question,Long type,Long firstlevel,Long secondlevel){
        Long tid = (Long) session.getAttribute("tid");
        Long subjectId = (Long) session.getAttribute("subjectId");
        TaskList taskList = new TaskList();
        taskList.setQuestion(question);
        taskList.setTid(subjectId);
        taskList.setSlevel(secondlevel);
        taskList.setTtype(type);
        taskList.setTeaId(tid);
        return taskListMapper.insert(taskList);
    }
    @RequestMapping("/upload")
    public String page(Model model,Long firstType,Long secondType,HttpSession session){

        Long subjectid= (Long) session.getAttribute("subjectId");
        List<TaskList> tasklist = taskService.findTaskListByLevel(subjectid,firstType,secondType);
        model.addAttribute("tasklist",tasklist);

        return "sxs/Trainer-taskupload";
    }
    @ResponseBody
    @GetMapping("/taskdelete/{taskId}")
    public int deletetask(@PathVariable("taskId") Long taskId){
       return taskMapper.deleteById(taskId);
    }
    /**
     * 新增
     * @param session
     * @param tasklistid
     * @return
     */
    //根据作业id删除其中一道题目
    @ResponseBody
    @PostMapping("/tasklist/detele")
    public int deleteTaskListInTask(HttpSession session,Long tasklistid){
        Long taskId = (Long) session.getAttribute("taskId");
        return taskService.removeTaskListInTask(taskId,tasklistid);
    }
}
