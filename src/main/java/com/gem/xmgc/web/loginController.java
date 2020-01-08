package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gem.xmgc.entity.AccountAll;
import com.gem.xmgc.entity.Discipline;
import com.gem.xmgc.entity.Manage;
import com.gem.xmgc.entity.Teacher;
import com.gem.xmgc.mapper.AccountAllMapper;
import com.gem.xmgc.mapper.ManageMapper;
import com.gem.xmgc.mapper.TeacherMapper;
import com.gem.xmgc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
@SessionAttributes(value = "AccountAll", types = AccountAll.class)
public class loginController {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountAllMapper accountAllMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ManageMapper manageMapper;
    @ResponseBody
    @PostMapping("/login")
    public String login(HttpSession session,String username,String password,String check){
        System.out.println(check);
        if("admin".equals(check)){
            Wrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("m_no",username).eq("m_password",password).eq("m_type","0");
            AccountAll accountAll = accountAllMapper.selectOne(wrapper);
            if(accountAll!=null){
                session.setAttribute("AccountAll",accountAll);
                return "admin";
            }else{
                return null;
            }

        }else if("eduadmin".equals(check)){
            Wrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("m_no",username).eq("m_password",password).eq("m_type","1");
            AccountAll accountAll = accountAllMapper.selectOne(wrapper);
            if(accountAll!=null){
                session.setAttribute("AccountAll",accountAll);
                return "eduadmin";
            }else{
                return null;
            }
        }
        else if("trainer".equals(check)){
            Wrapper<Teacher> wrapper = Wrappers.<Teacher>query().eq("t_id",username).eq("t_password",password);
            Teacher teacher = teacherMapper.selectOne(wrapper);
            if(teacher!=null){
                AccountAll accountAll = new AccountAll();
                accountAll.setMName(teacher.getTName());
                accountAll.setMNo(teacher.getTId());
                accountAll.setMPassword(teacher.getTPassword());
                accountAll.setMEmail(teacher.getEmail());
                session.setAttribute("AccountAll",accountAll);
                session.setAttribute("tid",teacher.getId());
                return "trainer";
            }else{
                return null;
            }
        }
        else if("headteacher".equals(check)){
            Wrapper<Manage> wrapper = Wrappers.<Manage>query().eq("m_id",username).eq("m_password",password);
            Manage manage = manageMapper.selectOne(wrapper);
            AccountAll accountAll = new AccountAll();
            accountAll.setMName(manage.getMName());
            accountAll.setMNo(manage.getMId());
            accountAll.setMPassword(manage.getMPassword());
            accountAll.setMEmail(manage.getEmail());
            if(manage!=null){
                session.setAttribute("AccountAll",accountAll);
                session.setAttribute("mid",manage.getId());
                return "headteacher";
            }else{
                return null;
            }
        }
        else if("xmadmin".equals(check)){
            Wrapper<AccountAll> wrapper = Wrappers.<AccountAll>query().eq("m_no",username).eq("m_password",password).eq("m_type","4");
            AccountAll accountAll = accountAllMapper.selectOne(wrapper);
            if(accountAll!=null){
                session.setAttribute("AccountAll",accountAll);
                return "xmadmin";
            }else{
                return null;
            }
        }
        return "null";
    }
    @GetMapping("/logout")
    @ResponseBody
    public String logout(SessionStatus sessionStatus) {
        //清空session
        sessionStatus.setComplete();
        System.out.println("我清空了 ");
        return "1";
    }

    @GetMapping("/crm")
    @ResponseBody
    public Discipline crm(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        System.out.println("遭遇未知袭击!!!!!!");
        Discipline discipline =new Discipline();
        discipline.setStatu(2);
        return discipline;
    }


}
