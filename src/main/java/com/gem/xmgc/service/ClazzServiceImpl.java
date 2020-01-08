package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级管理服务类
 */
@Service
@Transactional
public class ClazzServiceImpl {

    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    TClassMapper tClassMapper;
    @Autowired
    MClassMapper mClassMapper;

    Clazz clazz=new Clazz();

    TClass tClass=new TClass();

    MClass mClass=new MClass();


    //创建班级(Class实体类,需要对m_class,t_class做出相应添加)
    public Boolean createClazz(Clazz c) {
        tClass.setTId(c.getMId());
        tClass.setAddTime(LocalDateTime.now());
        tClass.setCId(1L);
        tClass.setStatu(1);
        tClass.setUpTime(LocalDateTime.now());
        tClassMapper.insert(tClass);
        mClass.setMId(c.getMId());
        mClass.setCId(1L);
        mClass.setStatu(1L);
        mClassMapper.insert(mClass);

        clazzMapper.insert(c);
        return true;
    }


    //通过id删除班级()
    public boolean removeClazz(Long id){
        clazzMapper.deleteById(1);
        return true;
    };

    //查询所有班级
    public List<Clazz> foundAllClazz(Long id){
        QueryWrapper<Clazz> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("type_id",id);
        return clazzMapper.selectList(queryWrapper);
    };
    //通过实训师id查询班级
    public IPage<Clazz> findAllClazz(Integer current){
        Page<Clazz> page=new Page<>(current,5);
        return clazzMapper.selectAllClazz(page);
    };
    //通过实训师id查询班级
    public List<Clazz> findClazzByTeacherId(Long id){

        return clazzMapper.selectClazzByTid(id);
    }



    public IPage<Clazz> findAllClazzByYear(Integer current,String year){
        Page<Clazz> page=new Page<>(current,5);
        return clazzMapper.selectClazzByYear(page,year);
    };
    public IPage<Clazz> findAllClazzBySubject(Integer current,String year){
        Page<Clazz> page=new Page<>(current,5);
        return clazzMapper.selectClazzBySubject(page,year);
    };
    //修改班级(需要对m_class,t_class做出相应修改)
    public boolean editClazz(Clazz c){
        QueryWrapper<TClass> queryWrapperTClass=new QueryWrapper<>();
        queryWrapperTClass.eq("c_id",c.getId());
        tClass.setTId(c.getTId());
        tClassMapper.update(tClass,queryWrapperTClass);
        QueryWrapper<MClass> queryWrapperMClass=new QueryWrapper<>();
        queryWrapperMClass.eq("c_id",c.getId());
        mClass.setMId(c.getMId());
        mClassMapper.update(mClass,queryWrapperMClass);
        c.setTId(null);
        c.setMId(null);
        clazzMapper.updateById(c);
        return true;
    };


    //通过实训师id查询班级
    public IPage<Clazz> findClazzByTeacherId(Long id,Integer current){
        Page<Clazz> page=new Page<>(current,5);
        return clazzMapper.selectClazzByTId(page,id);
    };

    //通过班主任id查询班级
    public IPage<Clazz> findClazzByManageId(Long id,Integer current){
        Page<Clazz> page=new Page<>(current,5);
        return clazzMapper.selectClazzByMId(page,id);
    };

    //根据年份查询班级
    //根据班级id查询班级信息（班级+t_class+m_class）
    //根据学科查询班级(学科空可以查询所有班级)传入学科ID(可以为空)
    public IPage<Clazz> findAllClazzBy(String year,Integer current,String subject){
        Page<Clazz> page=new Page<>(current,5);
        IPage<Clazz> clazzes= clazzMapper.selectClazzY(page,year,subject);
        return clazzes;
    };

    public IPage<Clazz> findAllClazzinfo(Integer current){
        Page<Clazz> page=new Page<>(current,5);
        return clazzMapper.selectAllClazzInfo(page);
    };
    public Clazz findAllClazzById(Long id){
        return clazzMapper.selectAllClazzById(id);
    };
//查询所有实训师
    @Autowired
    TeacherMapper teacherMapper;
    public List<Teacher> findAllTeacher(){
       return teacherMapper.selectList(null);
    }
    @Autowired
    ManageMapper manageMapper;
    public List<Manage> findAllManager(){
        return manageMapper.selectList(null);
    }

    public IPage<Clazz> findClazzById(Long id,Integer current){
        Page<Clazz> page=new Page<>(current,5);
        QueryWrapper<Clazz> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        IPage<Clazz> clazzes= clazzMapper.selectPage(page,queryWrapper);
        return clazzes;
    };


    @Autowired
    NewClassDetailMapper newClassDetailMapper;
    //(班级测试计划)

    //添加班级测试计划
    public boolean createClassTest(NewClassDetail newclassdetal){
        newClassDetailMapper.insert(newclassdetal);
        return true;
    };

    //修改班级测试计划
    public boolean editClassTest(NewClassDetail newclassdetal){
        newClassDetailMapper.updateById(newclassdetal);
        return true;
    };

    //通过id删除班级测试计划(伪删除)
    public boolean removeClassTest(Long id){
        newClassDetailMapper.deleteById(id);
        return true;
    };

    public NewClassDetail findClassTestById(Long  id){
        QueryWrapper<NewClassDetail> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return newClassDetailMapper.selectOne(queryWrapper);
    };
    //通过学科ID和班级ID查找班级测试计划或通过id查询班级测试计划
    public IPage<NewClassDetail> findClassTestBySubjectAndName(Long  subjectId, Long classId,Integer current){
        Page<NewClassDetail> page=new Page<>(current,5);
        NewClassDetail newClassDetail=new NewClassDetail();
        newClassDetail.setCid(classId);
        newClassDetail.setThing(subjectId);
        LambdaQueryWrapper<NewClassDetail> queryWrapper= Wrappers.lambdaQuery(newClassDetail);
        return newClassDetailMapper.selectPage(page,queryWrapper);
    };
    public IPage<NewClassDetail> findAllClassTest(Integer current){
        Page<NewClassDetail> page=new Page<>(current,5);
        return newClassDetailMapper.selectPage(page,null);
    };
    @Autowired
    ClassDetailMapper classDetailMapper;
    public IPage<ClassDetail> findAllClassTests(Integer current){
        Page<ClassDetail> page=new Page<>(current,5);
        return classDetailMapper.selectNewClassDetail(page);
    };
    public IPage<ClassDetail> findAllClassTestsByClazz(Integer current,Long id){
        Page<ClassDetail> page=new Page<>(current,5);
        return classDetailMapper.selectNewClassDetailByClazz(page,id);
    };

    @Autowired
    SearchTypeMapper searchTypeMapper;
    public Long searchTypeId(String name){
        QueryWrapper<SearchType> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("typename",name);
        return searchTypeMapper.selectOne(queryWrapper).getId();
    }


    //新增

    /**
     * 根据班级id查询班级
     * @param id 班级id
     * @return
     */
    public Clazz getClazzById(Long id){
        return clazzMapper.selectById(id);
    }
    //新增
    //通过班主任id查询班级
    public List<Clazz> findClazzByManageId(Long id){
        return clazzMapper.selectClazzByMid(id);
    }





}
