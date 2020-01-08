package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 张开
 * @date 2019/10/24 8:43
 */
@Service
public class AccountService{
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ManageMapper manageMapper;
    @Autowired
    AccountAllMapper accountAllMapper;
    @Autowired
    EmailccMapper emailccMapper;
    @Autowired
    SubjectTypeMapper subjectTypeMapper;
    /**
    * @author 张开
    * @date 2019/10/24 15:53
    * @description 创建实训师
    */
    public boolean createTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 16:13
    * @description 查询实训师通过名字
    */
    public IPage<Teacher> findTeacherByName(String name) {
        Page<Teacher> page = new Page<>(1,5);
        QueryWrapper<Teacher> queryWrapper = Wrappers.<Teacher>query().eq("t_name",name);
        return teacherMapper.selectPage(page,queryWrapper);
    }


    /**
    * @author 张开
    * @date 2019/10/24 15:53
    * @description 创建班主任
    */
    public boolean createManage(Manage manage) {
        manageMapper.insert(manage);
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 16:14
    * @description 查询班主任通过名字
    */
    public IPage<Manage> findManageByName(String name) {
        Page<Manage> page = new Page<>(1,5);
        QueryWrapper<Manage> queryWrapper = Wrappers.<Manage>query().eq("m_name",name);
        return manageMapper.selectPage(page,queryWrapper);
    }

    /**
    * @author 张开
    * @date 2019/10/24 15:53
    * @description 创建超级管理员/教务/项目工厂账号
    */
    public boolean createAccount(AccountAll accountAll) {
        accountAllMapper.insert(accountAll);
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 15:45
    * @description 添加经理账户
    */
    public boolean createEmailcc(Emailcc emailcc) {
        emailccMapper.insert(emailcc);
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 15:47
    * @description 查询所有经理账号
    */
    public IPage<Emailcc> findAllEmailcc(int current,String name) {
        Page<Emailcc> page = new Page<>(current,5);
        QueryWrapper<Emailcc> wrapper = Wrappers.query();
        wrapper.eq(StringUtils.isNotEmpty(name),"username",name);
        return emailccMapper.selectPage(page,wrapper);
    }
    /**
    * @author 张开
    * @date 2019/10/24 15:47
    * @description 通过名字查询经理账号
    */
    public IPage<Emailcc> findEmailccByName(String name) {
        Page<Emailcc> page = new Page<>(1,5);
        QueryWrapper<Emailcc> queryWrapper = Wrappers.<Emailcc>query().eq("username",name);
        return emailccMapper.selectPage(page,queryWrapper);

    }
    /**
    * @author 张开
    * @date 2019/10/24 15:50
    * @description 删除经理账号通过id
    */
    public boolean removeEmailccById(long id) {
        emailccMapper.deleteById(id);
        return true;
    }
    /**
     * @author 张开
     * @date 2019/10/24 15:52
     * @description 编辑经理账户
     */
    public boolean editEmailcc(Emailcc emailcc) {
        emailccMapper.update(emailcc,null);
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 15:04
    * @description 查询三种账户类型的信息
    */
    public IPage<AccountAll> findAcount(String type, String name) {
            Page<AccountAll> page = new Page<>(1,5);
            QueryWrapper<AccountAll> queryWrapper = Wrappers.<AccountAll>query().eq("m_name", name).eq("m_type",type);
            return accountAllMapper.selectPage(page,queryWrapper);
    }
    /**
    * @author 张开
    * @date 2019/10/24 14:01
    * @description 修改账户
    */
    public boolean editAccount(String type, Object object) {
    if ("teacher".equals(type)){
        teacherMapper.update((Teacher)object,null);
    }else if("manage".equals(type)){
        manageMapper.update((Manage)object,null);
    }else{
        accountAllMapper.update((AccountAll)object,null);
    }
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 14:00
    * @description 通过id,账户类型删除账户
    */
    public boolean removeAccount(String type, long id) {
        if ("teacher".equals(type)){
            teacherMapper.deleteById(id);
        }else if("manage".equals(type)){
            manageMapper.deleteById(id);
        }else{
            accountAllMapper.deleteById(id);
        }
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 13:21
    * @description :通过学科名称查询所有的实训师
    */
    public IPage<Teacher> findTeacherBySubject(String subjectname) {
        Page<Teacher> page = new Page<>(1,5);
        QueryWrapper<SubjectType> queryWrapper = Wrappers.<SubjectType>query().eq("type_name",subjectname);
        SubjectType subjectType = subjectTypeMapper.selectOne(queryWrapper);
        Long id = subjectType.getId();
        return teacherMapper.selectPage(page,Wrappers.<Teacher>query().eq("type_id",id));
    }


    public Teacher findTeacherOne(String name) {
        QueryWrapper<Teacher> queryWrapper = Wrappers.<Teacher>query().eq("t_name",name);
        return teacherMapper.selectOne(queryWrapper);
    }


    public Manage findManageOne(String name) {
        QueryWrapper<Manage> queryWrapper = Wrappers.<Manage>query().eq("m_name",name);
        return manageMapper.selectOne(queryWrapper);
    }


}
