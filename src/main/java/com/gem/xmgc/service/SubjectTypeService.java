package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学科管理服务类
 */
@Service
public class SubjectTypeService {
    @Autowired
    SubjectTypeMapper subjectTypeMapper;
    //创建学科(SubjectType实体类)
    public boolean createSubject(SubjectType subjectType){
        subjectType.setStatu(0L);
        subjectTypeMapper.insert(subjectType);
        return true;
    };
    //通过学科id删除
    public boolean removeSubject(long id){
        subjectTypeMapper.deleteById(id);
        return true;
    };

    //编辑学科(subjecttype中要含学科ID)
    public boolean editSubject(SubjectType subjectType){
        subjectTypeMapper.updateById(subjectType);
        return true;
    };

    //查询所有学科方向
    public List<SubjectType> findAllSubject(){
        return subjectTypeMapper.selectList(null);
    };

    //查询学科名通过学科id
    public SubjectType findSubjectByName(String tname){
        QueryWrapper<SubjectType> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("type_name",tname);
        return subjectTypeMapper.selectOne(queryWrapper);
    };
    //查询学科id通过学科方向
    public SubjectType findSubjectById(Long id){
        QueryWrapper<SubjectType> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return subjectTypeMapper.selectOne(queryWrapper);
    };
//(学科模块)
    @Autowired
    FirstLevelMapper firstLevelMapper;
    //创建一级模块
    public Boolean createFirstLevel(FirstLevel firstLevel){
        firstLevelMapper.insert(firstLevel);
        return true;
    };
    public FirstLevel findFirstLevelByName(String name){
        QueryWrapper<FirstLevel> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("f_name",name);
        return firstLevelMapper.selectOne(queryWrapper);
    }

    //查询所有的一级模块(不分页)
    public IPage<FirstLevel> findFirstLevelAll(Long subjectId,Integer current){
        Page<FirstLevel> page=new Page<>(current,5);
        FirstLevel firstLevel=new FirstLevel();
        firstLevel.setTypeId(subjectId);
        QueryWrapper<FirstLevel> queryWrapper= Wrappers.query(firstLevel);
        return firstLevelMapper.selectPage(page,queryWrapper);
    };
    //查询所有的一级模块(不分页)
    public List<FirstLevel> findFirstLevelAll(Long subjectId){
        FirstLevel firstLevel=new FirstLevel();
        firstLevel.setTypeId(subjectId);
        QueryWrapper<FirstLevel> queryWrapper= Wrappers.query(firstLevel);
        return firstLevelMapper.selectList(queryWrapper);
    }


    public List<FirstLevel> findFirstLevelAllBySubject(Long subjectId){
        FirstLevel firstLevel=new FirstLevel();
        firstLevel.setTypeId(subjectId);
        QueryWrapper<FirstLevel> queryWrapper= Wrappers.query(firstLevel);
        return firstLevelMapper.selectList(queryWrapper);
    };
    public FirstLevel findFirstAllById(Long subjectId){
        FirstLevel firstLevel=new FirstLevel();
        firstLevel.setId(subjectId);
        QueryWrapper<FirstLevel> queryWrapper= Wrappers.query(firstLevel);
        return firstLevelMapper.selectOne(queryWrapper);
    };
    // 通过学科查询一级模块Id
    public IPage<FirstLevel> findFirstAll(Integer current,Long subjectId){
        Page<FirstLevel> page=new Page<>(current,5);
        FirstLevel firstLevel=new FirstLevel();
        firstLevel.setTypeId(subjectId);
        QueryWrapper<FirstLevel> queryWrapper= Wrappers.query(firstLevel);
        return firstLevelMapper.selectPage(page,queryWrapper);
    };
    //修改一级模块(需包含ID)
    public boolean editFirstLevel(FirstLevel firstlevel){
        firstLevelMapper.updateById(firstlevel);
        return true;
    };

    //通过id删除一级模块(伪删除)
    public boolean removeFirstLevelById(long id){
        firstLevelMapper.deleteById(id);
        return true;
    };
    @Autowired
    SecondLevelMapper secondLevelMapper;
    //创建二级模块(一级模块id)
    SecondLevel secondLevel=new SecondLevel();
    public boolean createSecondLevel(long id, String name){
        secondLevel.setSName(name);
        secondLevel.setFId(id);
        secondLevelMapper.insert(secondLevel);
        return true;
    };
    //查询所有的二级模块(一级模块id)
    public IPage<SecondLevel> findSecondAll(Long id,Integer current){
        Page<SecondLevel> page=new Page<>(current,5);
        return secondLevelMapper.selectAllSecondLevelsById(page,id);
    };
    public List<SecondLevel> findSecond(Long id){
        QueryWrapper<SecondLevel> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("f_id",id);
        return secondLevelMapper.selectList(queryWrapper);
    };
    //根据ID查询二级模块
    public SecondLevel findSecondById(Long id){
        return secondLevelMapper.selectSecondLevelsById(id);
    };
    //查询所有二级模块
    public IPage<SecondLevel> findAllSecondLevel(Integer current){
        Page<SecondLevel> page=new Page<>(current,5);
        return secondLevelMapper.selectAllSecondLevels(page);
    };

    //修改二级模块(需含Id)
    public boolean editSecondtLevel(SecondLevel secondlevel){
        secondLevelMapper.updateById(secondlevel);
        return true;
    };

    //通过id删除二级模块
    public boolean removeSecondLevelById(long id){
        secondLevelMapper.deleteById(id);
        return true;
    };
    @Autowired
    SubjectContentMapper subjectContentMapper;
    @Autowired
    SubjectContentDetailMapper subjectContentDetailMapper;
//(学科测试计划)
    //添加学科测试计划(SubjectContent实体类)
    public boolean createSubjectTest(SubjectContent subjectContent,SubjectContentDetail subjectContentDetail){
        subjectContentMapper.insert(subjectContent);
        subjectContentDetail.setSid(subjectContent.getId());
        subjectContentDetailMapper.insert(subjectContentDetail);
        return true;
    };

    //修改学科测试计划(需学科Id)
    public boolean editSubjectTest(SubjectContent subjectContent,SubjectContentDetail subjectContentDetail){
        subjectContentMapper.updateById(subjectContent);
        subjectContentDetailMapper.updateById(subjectContentDetail);
        return true;
    };

    //通过id删除测试计划(伪删除)
    public boolean removeSubjectTest(long id){
        subjectContentMapper.deleteById(id);
        return true;
    };

    //通过查找所有测试计划
    public IPage<SubjectContent> findSubjectTestBySubject(Integer current){
        Page<SubjectContent> page=new Page<>(current,5);
      return  subjectContentMapper.selectSubjectPlan(page);
    };
    //通过学科id查找测试计划
    public IPage<SubjectContent> findSubjectTestBySubjectId(Long subjectid,Integer current){
        Page<SubjectContent> page=new Page<>(current,5);
        return  subjectContentMapper.selectSubjectPlanBysubjectId(page,subjectid);
    };
    //通过id查找测试计划
    public SubjectContent findSubjectTestById(Long subjectid){
        return  subjectContentMapper.selectSubjectPlanById(subjectid);
    };
    public List<SubjectContent> findAllSubjectTest(){
        return subjectContentMapper.selectList(null);
    };
    //通过id查找测试计划详情
    public SubjectContentDetail findSubjectTestDetailById(Long subjectid){
        return  subjectContentDetailMapper.selectSbujectContentDetailById(subjectid);
    };
    //通过删除测试计划详情
    public boolean removeSubjectTestDetailById(Long subjectid){
        subjectContentDetailMapper.deleteById(subjectid);
        return true;

    };
    @Autowired
    TestTypeMapper testTypeMapper;
    //题目类型
    public List<TestType> findTestType(){
        return testTypeMapper.selectList(null);
    };


    /**
     * 新增
     * 通过一级模块id查询二级模块
     *
     */
    public List<SecondLevel> findSecondLevelById(Long id){
        QueryWrapper<SecondLevel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("f_id",id);
        return secondLevelMapper.selectList(queryWrapper);
    }



}
