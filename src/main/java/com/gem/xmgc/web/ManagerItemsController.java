package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import com.gem.xmgc.service.AccountService;
import com.gem.xmgc.service.SubjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(names = "subjectTypes",value = "subjectTypes")
@RequestMapping("/list")
public class ManagerItemsController {
    @Autowired
    AccountService accountService;
    @Autowired
    SubjectTypeMapper subjectTypeMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ManageMapper manageMapper;
    @Autowired
    EmailccMapper emailccMapper;
    @Autowired
    SubjectTypeService subjectTypeService;
    @Autowired
    AccountAllMapper accountAllMapper;
    @Autowired
    ClazzMapper clazzMapper;



    @RequestMapping("/createAccount")
    @ResponseBody
    public String createAccount(String relname,String username,String password,String email,String itemCate,String subType){
        System.out.println(subType);
        System.out.println(itemCate);
        if("2".equals(itemCate)){
            Wrapper<SubjectType> wrapper = Wrappers.<SubjectType>query().eq("type_name",subType);
            SubjectType subjectType =subjectTypeMapper.selectOne(wrapper);
            Long id =subjectType.getId();
            Teacher teacher = new Teacher();
            teacher.setTName(relname);
            teacher.setTId(username);
            teacher.setTPassword(password);
            teacher.setEmail(email);
            teacher.setTypeId(id);
            teacherMapper.insert(teacher);
        } else if("3".equals(itemCate)){
            Manage manage = new Manage();
            manage.setMName(relname);
            manage.setMPassword(password);
            manage.setMId(username);
            manage.setFlag(null);
            manage.setEmail(email);
            manageMapper.insert(manage);
      }else{
            AccountAll accountAll = new AccountAll();
            accountAll.setMName(relname);
            accountAll.setMNo(username);
            accountAll.setMPassword(password);
            accountAll.setMEmail(email);
            accountAll.setMType(itemCate);
            accountService.createAccount(accountAll);
      }
        return "1";
    }
    @PostMapping("/createEmailcc")
    @ResponseBody
    public String createAccount(String username,String email){
        Emailcc emailcc = new Emailcc();
        emailcc.setUsername(username);
        emailcc.setEmail(email);
        emailccMapper.insert(emailcc);
           return "1";
        }

    @GetMapping("/manageredit/{id}")
    public String manageredit(Model model,@PathVariable("id") Long id){
        System.out.println(id);
        Wrapper<Emailcc> wrapper = Wrappers.<Emailcc>query().eq("id",id);
        Emailcc emailcc = emailccMapper.selectOne(wrapper);
        model.addAttribute("emailcc",emailcc);
        return "manager/managerEdit_change";
    }
    @GetMapping("/managerChange")
    @ResponseBody
    public String managerChange(String username,String email,String emailccId){
        System.out.println(emailccId);
        System.out.println(username);
        System.out.println(email);
        Emailcc emailcc = new Emailcc();
        emailcc.setUsername(username);
        emailcc.setEmail(email);
        new UpdateChainWrapper<>(emailccMapper).eq("id",emailccId).update(emailcc);
        return "1";
    }

    @ResponseBody
    @GetMapping("/manageremailcc/one")
    public IPage<Emailcc> manageremailcc1(Model model,Integer current,String name){
        System.out.println("_____________________");
        System.out.println(name);
        System.out.println(current);
        IPage<Emailcc> ipage = accountService.findAllEmailcc(current,name);
        System.out.println(ipage);
        model.addAttribute("emails",ipage);
        return ipage;
    }
    @GetMapping("/manageremailcc/two")
    @ResponseBody
    public IPage<Emailcc> manageremailcc2(Model model,String emailname){
        System.out.println(emailname);
        IPage<Emailcc> ipage = accountService.findEmailccByName(emailname);
        System.out.println(ipage);
        return ipage;
    }
    @PostMapping("/managedelete/{id}")
    @ResponseBody
    public String managedelete(@PathVariable("id") Long id){
        Wrapper<Emailcc> wrapper = Wrappers.<Emailcc>query().eq("id",id);
        emailccMapper.delete(wrapper);
        return "1";
    }
    @ResponseBody
    @DeleteMapping("/managerAllDelete")
    public String managerAllDelete(@RequestParam(value="ids") Integer[] Allid){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Integer i:Allid){
            arrayList.add(i);
        }
       emailccMapper.deleteBatchIds(arrayList);
        return "1";
    }


    @RequestMapping("/precreateAccount")
    public String precreateAccount(Model model, HttpSession session){
        List<SubjectType> subjectTypes = subjectTypeService.findAllSubject();
        System.out.println(subjectTypes);
        model.addAttribute("subjects",subjectTypes);
        return "manager/CreateAccount";
    }

    @RequestMapping("/Subject/one")
    @ResponseBody
    public List<SubjectType> SubjectOne(){
        List<SubjectType> subjectTypes = subjectTypeService.findAllSubject();
        System.out.println(subjectTypes);
        return subjectTypes;
    }
    @RequestMapping("/Subject/two")
    @ResponseBody
    public List<SubjectType> SubjectTwo(String subjectname){
       Wrapper<SubjectType> wrapper = Wrappers.<SubjectType>query().eq("type_name",subjectname);
          return  subjectTypeMapper.selectList(wrapper);
    }
    /**
    * @author 张开
    * @date 2019/10/30 9:57
    * @description 通过id找到对应学科对象
    */
    @GetMapping("/newSubjectChange/{id}")
    public String newSubjectChange(Model model,@PathVariable("id") Long id){
        System.out.println(id);
        Wrapper<SubjectType> wrapper = Wrappers.<SubjectType>query().eq("id",id);
        SubjectType subjectType = subjectTypeMapper.selectOne(wrapper);
        model.addAttribute("subjectType",subjectType);
        return "manager/newSubject_change";
    }
    /**
    * @author 张开
    * @date 2019/10/30 9:57
    * @description 添加学科
    */
    @PostMapping("/newSubjectAdd")
    @ResponseBody
    public String newSubjectAdd(String newsubject){
        SubjectType subjectType = new SubjectType();
        subjectType.setTypeName(newsubject);
       subjectTypeMapper.insert(subjectType);
        return "1";
    }
    /**
    * @author 张开
    * @date 2019/10/30 9:56
    * @description 编辑学科
    */
    @PostMapping("/newSubjectChange")
    @ResponseBody
    public String newSubjectChange(String newsubject, String id){
       SubjectType subjectType = new SubjectType();
       subjectType.setTypeName(newsubject);
        new UpdateChainWrapper<>(subjectTypeMapper).eq("id",id).update(subjectType);
        return "1";
    }
    /**
    * @author 张开
    * @date 2019/10/30 10:02
    * @description 传id删除学科
    */
    @PostMapping("/newSubjectDelete/{id}")
    @ResponseBody
    public String newSubjectDelete(@PathVariable("id") Long id){
        Wrapper<Teacher> wrapperT = Wrappers.<Teacher>query().eq("type_id",id);
        Wrapper<Clazz> wrapperC = Wrappers.<Clazz>query().eq("type_id",id);
        List<Teacher> teachers = teacherMapper.selectList(wrapperT);
        List<Clazz> clazzes = clazzMapper.selectList(wrapperC);
        System.out.println("___________________");
        System.out.println(teachers.size());
        System.out.println(teachers);
        System.out.println(clazzes.size());
        System.out.println(clazzes);
        if(teachers.size()!=0){
            return "0";
        }else if(clazzes.size()!=0){
            return "0";
        }else{
            Wrapper<SubjectType> wrapper = Wrappers.<SubjectType>query().eq("id",id);
            subjectTypeMapper.delete(wrapper);
            return "1";
        }

    }
    /**
    * @author 张开
    * @date 2019/10/30 13:55
    * @description 账户预览分页 传页数
    */

    @GetMapping("/allShow/one")
    @ResponseBody
    public IPage allShow(Integer current,String person,String name){
        System.out.println("______________________");
        System.out.println(current);
        System.out.println(person);
        System.out.println(name);
        Page<AccountAll> AllPage = new Page<>(current,5);
        Page<Teacher> TeacherPage = new Page<>(current,5);
        Page<Manage> ManagePage = new Page<>(current,5);
                if("supermanager".equals(person)){
                    QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("m_type",0);
                    wrapper.eq(StringUtils.isNotEmpty(name),"m_name",name);
                    IPage<AccountAll> page =  accountAllMapper.selectPage(AllPage,wrapper);
                    return page;
                }else if("worker".equals(person)){
                    QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("m_type",1);
                    wrapper.eq(StringUtils.isNotEmpty(name),"m_name",name);
                    IPage<AccountAll> page =  accountAllMapper.selectPage(AllPage,wrapper);
                    return page;

                }else if("xmgcmanager".equals(person)){
                    QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("m_type",4);
                    wrapper.eq(StringUtils.isNotEmpty(name),"m_name",name);
                    IPage<AccountAll> page =  accountAllMapper.selectPage(AllPage,wrapper);
                    return page;

                }else if("relteacher".equals(person)){
                    QueryWrapper<Teacher> wrapper = Wrappers.query();
                    wrapper.eq(StringUtils.isNotEmpty(name),"t_name",name);
                    return teacherMapper.selectPage(TeacherPage,wrapper);

                }else if("manage".equals(person)){
                    QueryWrapper<Manage> wrapper = Wrappers.query();
                    wrapper.eq(StringUtils.isNotEmpty(name),"m_name",name);
                    return manageMapper.selectPage(ManagePage,wrapper);
                }
                return null;
    }
    /**
    * @author 张开
    * @date 2019/10/31 10:24
    * @description  账户预览单个删除
    */
    @PostMapping("/allShowdelOne/{id}")
    @ResponseBody
    public String allShowdelOne(@PathVariable("id") Long id,String person){
        System.out.println(person);
        if("supermanager".equals(person)){
           accountAllMapper.deleteById(id);
        }else if("worker".equals(person)){
            accountAllMapper.deleteById(id);
        }else if("xmgcmanager".equals(person)){
            accountAllMapper.deleteById(id);
        }else if("relteacher".equals(person)){
            teacherMapper.deleteById(id);
        }else if("manage".equals(person)){
            manageMapper.deleteById(id);
        }
        return "1";
    }
    /**
    * @author 张开
    * @date 2019/10/31 15:16
    * @description  通过条件返回ipage  带分页效果
    */
    @GetMapping("/allShow/{id}/{name}")
    public String allShow(Model model,@PathVariable("id") Long id,@PathVariable("name") String person){
        List<SubjectType> subjects = subjectTypeMapper.selectList(null);
        model.addAttribute("subjects",subjects);
        if("supermanager".equals(person)){
            QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("id",id);
            AccountAll a = accountAllMapper.selectOne(wrapper);
            a.setSubjecttype("无");
            model.addAttribute("model",a);
        }else if("worker".equals(person)){
            QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("id",id);
            AccountAll a = accountAllMapper.selectOne(wrapper);
            a.setSubjecttype("无");
            model.addAttribute("model",a);
        }else if("xmgcmanager".equals(person)){
            QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("id",id);
            AccountAll a = accountAllMapper.selectOne(wrapper);
            a.setSubjecttype("无");
            model.addAttribute("model",a);
        }else if("relteacher".equals(person)){
            QueryWrapper<Teacher> wrapper = Wrappers.<Teacher>query().eq("id",id);
            Teacher ta = teacherMapper.selectOne(wrapper);
            Long typeid = ta.getTypeId();
            QueryWrapper<SubjectType> typewrapper = Wrappers.<SubjectType>query().eq("id",typeid);
            AccountAll a = new AccountAll();
            Long tid = ta.getId();
            Integer aid = tid.intValue();
            a.setId(aid);
            a.setMName(ta.getTName());
            a.setMPassword(ta.getTPassword());
            a.setMEmail(ta.getEmail());
            a.setMType("2");
            SubjectType subjectType = subjectTypeMapper.selectOne(typewrapper);
            String typename = subjectType.getTypeName();
            a.setSubjecttype(typename);
            model.addAttribute("model",a);
        }else if("manage".equals(person)){
            QueryWrapper<Manage> wrapper = Wrappers.<Manage>query().eq("id",id);
            Manage a = manageMapper.selectOne(wrapper);
            AccountAll a2 = new AccountAll();
            Long id2 = a.getId();
            Integer allid = id2.intValue();
            a2.setId(allid);
            a2.setMName(a.getMName());
            a2.setMPassword(a.getMPassword());
            a2.setMEmail(a.getEmail());
            a2.setMType("3");
            a2.setSubjecttype("无");
            model.addAttribute("model",a2);
        }
        return "manager/allShowEdit";
    }


    /**
    * @author 张开
    * @date 2019/10/31 15:16
    * @description 编辑 账户一览
    */
    @PostMapping("/showAllEdit")
    @ResponseBody
    public String showAllEdit(String Id,String username,String password,String email,String subjecttype){
        System.out.println("_________________");
        System.out.println(Id+".."+username+"..."+password+"...."+email+"..."+subjecttype);
       if("0".equals(subjecttype)){
            //超级管理员
           AccountAll accountAll = new AccountAll();
           accountAll.setMName(username);
           accountAll.setMPassword(password);
           accountAll.setMType(subjecttype);
           QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("id",Id);
           accountAllMapper.update(accountAll,wrapper);
            return "1";
        }else if("1".equals(subjecttype)){
            //教务
           AccountAll accountAll = new AccountAll();
           accountAll.setMName(username);
           accountAll.setMPassword(password);
           accountAll.setMType(subjecttype);
           QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("id",Id);
           accountAllMapper.update(accountAll,wrapper);
            return "1";
        }else if("2".equals(subjecttype)){
            //实训师
           Teacher teacher = new Teacher();
           teacher.setTName(username);
           teacher.setTPassword(password);
           teacher.setEmail(email);
           QueryWrapper<Teacher> wrapper = Wrappers.<Teacher>query().eq("id",Id);
           teacherMapper.update(teacher,wrapper);
            return "1";
        }else if("3".equals(subjecttype)){
            //班主任
           Manage manage = new Manage();
           manage.setMName(username);
           manage.setMPassword(password);
           manage.setEmail(email);
           QueryWrapper<Manage> wrapper = Wrappers.<Manage>query().eq("id",Id);
           manageMapper.update(manage,wrapper);
            return "1";
        }else if("4".equals(subjecttype)){
            //项目工厂管理员
           AccountAll accountAll = new AccountAll();
           accountAll.setMName(username);
           accountAll.setMPassword(password);
           accountAll.setMType(subjecttype);
           QueryWrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("id",Id);
           accountAllMapper.update(accountAll,wrapper);
           return "1";
        }else{
           return "0";
       }
    }






}
