package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import com.gem.xmgc.util.ObjIsNotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  成绩服务类
 * @author jiowww
 * @data 2019/10/25
 */
@Service
public class ScoreService {

    //注入SubjectMapper(项目详情)
    @Autowired
    SubjectCheckMapper subjectCheckMapper;

    //注入ClazzMapper班级
    @Autowired
    ClazzMapper clazzMapper;

    //注入SubjectType
    @Autowired
    SubjectTypeMapper subjectTypeMapper;

    //注入StudentMapper
    @Autowired
    StudentMapper studentMapper;

    //注入WrittenIntervie
    @Autowired
    WrittenIntervieMapper writtenIntervieMapper;

    //注入AllScoreObjectMapper
    @Autowired
    AllScoreObjectMapper allScoreObjectMapper;

    //注入ScoreObjectMapper
    @Autowired
    ScoreObjectMapper scoreObjectMapper;

    //注入scoreMapper
    @Autowired
    ScoreMapper scoreMapper;

    @Autowired
    WrittenInterviewViewMapper writtenInterviewViewMapper;


    //每页显示几条
    Integer size = 5;
    //(学生成绩)

    /**
     * 通过班级id查询所有学生成绩,返回自定义对象ScoreObject
     * ScoreObject(学生id,学生姓名,【考试名称、成绩】集合
     *
     * @param id 班级id
     * @return 所有学生的ScoreObject(分页显示)
     */

    //(学生成绩)


    public List<StudentScore> findAllStudentScore(Long id) {
        QueryWrapper<StudentScore> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(id),"st.c_id",id);
        return scoreMapper.findStudentScoresByStudentId(queryWrapper);
    }




    public List<ScoreView> findScoresViewByStudentId(Long id) {
        QueryWrapper<ScoreView> queryWrapper = Wrappers.query();
        queryWrapper.eq("s.s_id",id);
        return scoreMapper.findScoresViewByStudentId(queryWrapper);
    }






    /**
     * 通过学生id查询学生成绩
     *
     * @param id 学生id
     * @return ScoreObject(自定义成绩对象)
     */

    /**
     * 通过班级id,学生姓名,试卷名称查寻试卷成绩
     *
     * @param id 班级id
     * @param name 学生姓名
     * @param pName 试卷名称
     * @return ScoreObject(自定义成绩对象)
     */

    //(笔试面试)


    /**
     * 通过班级id
     * @param id 班级id
     * @return
     */
    public List<WrittenInterviewView> findAllWrittenAndInterview(Long id) {
        QueryWrapper<WrittenInterviewView> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(id),"s.c_id",id);
        return writtenInterviewViewMapper.findAllWrittenAndInterview(queryWrapper);
    }





    /**
     * 通过班级id和学生姓名查询笔试面试成绩;(笔试面试实体类(Written_Intervie)
     * @param id 班级id
     * @param name 学生姓名
     * @return
     */
    public IPage<WrittenInterviewView> findAllWrittenAndInterviewView(Long id, String name,Integer current) {
        Page<WrittenInterviewView> page = new Page<>(current,size);
        QueryWrapper<WrittenInterviewView> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(id),"s.c_id",id).eq(StringUtils.isNotEmpty(name),"s_name",name);
        return writtenInterviewViewMapper.findAllWrittenAndIntervie(page,queryWrapper);
    }

    /**
     * 通过班级id和学生姓名查询笔试面试成绩;(笔试面试实体类(Written_Intervie)
     * @param id 班级id
     * @param name 学生姓名
     * @return
     */
    public WrittenInterviewView findWrittenAndInterviewViewById(Long id) {
        QueryWrapper<WrittenInterviewView> queryWrapper = Wrappers.query();
        queryWrapper.eq("id",id);
        return writtenInterviewViewMapper.selectById(id);
    }


    public WrittenIntervie findWrittenAndIntervieById(Long id) {
        QueryWrapper<WrittenIntervie> queryWrapper = Wrappers.query();
        queryWrapper.eq("id",id);
        return writtenIntervieMapper.selectById(id);
    }

    public IPage<WrittenIntervie> findAllWrittenAndIntervie(Long id, String name,Integer current) {
        Page<WrittenIntervie> page = new Page<>(current,size);
        QueryWrapper<WrittenIntervie> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(id),"s.c_id",id).eq(StringUtils.isNotEmpty(name),"s_name",name);
        return writtenIntervieMapper.findAllWrittenAndIntervie(page,queryWrapper);
    }



    /**
     * 修改笔试面试结果
     * @param writtenIntervie 包含笔试面试表id的对象
     * @return
     */
    public boolean editWrittenAndIntervie(WrittenInterviewView writtenIntervie) {
        writtenInterviewViewMapper.updateById(writtenIntervie);
        return true;
    }


    //(最终评定)
    /**
     * 通过班级id查询所有学生的成绩总表,返回自定义对象(学生姓名,模拟面试,模拟鄙视,答辩项目名称,项目验收,是否通过,线上信息是否提交完成,建立是否合格,等级))
     *
     * @param id 班级id
     * @param current 每页几条记录
     */
    public IPage<AllScoreObject> findAllResult(Long id,Integer current) {
        Page<AllScoreObject> page = new Page<>(current,size);
        QueryWrapper<AllScoreObject> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(id),"c.id",id);
        return allScoreObjectMapper.selectAllScoreObjects(page,queryWrapper);
    }


    /**
     * 多条件查询最终成绩
     * @param id 班级id
     * @return
     */
    public List<AllScoreObject> findAllScoreObject(Long id){
        QueryWrapper<AllScoreObject> queryWrapper = Wrappers.query();
        queryWrapper.eq("c.id",id);
        return allScoreObjectMapper.selectScoreObjects(queryWrapper);
    }

    /**
     * 多条件查询最终成绩
     * @param stuName 学生姓名
     * @param fScore 面试成绩
     * @param wScore 笔试成绩
     * @param underCheck 线下是否提交
     * @param onlineCheck 线上是否提交
     * @param piResumeIsok 简历是否合格
     * @param piComprehensiveQuality 等级
     * @param current 第几页
     * @return
     */
    public IPage<AllScoreObject> findAllScoreObject(Long id,String stuName,String fScore,String wScore,Integer underCheck,Integer onlineCheck,Integer piResumeIsok,String piComprehensiveQuality,Integer current){
        Page<AllScoreObject> page  = new Page<>(current,size);
        //过滤条件：学生姓名
        QueryWrapper<AllScoreObject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(stuName),"s_name",stuName).eq(ObjIsNotEmpty.isNotEmpty(id),"s.c_id",id);
        //过滤条件：面试是否通过
        if (fScore != null && "PASS".equals(fScore)){
            queryWrapper.ge("f_score",60);
        }else if(fScore != null && "FAIL".equals(fScore)){
            queryWrapper.lt("f_score",60);
        }
        //过滤条件：笔试是否通过
        if (wScore != null && "PASS".equals(wScore)){
            queryWrapper.ge("w_score",60);
        }else if(wScore != null && "FAIL".equals(wScore)){
            queryWrapper.lt("w_score",60);
        }
        queryWrapper
                //过滤条件：项目验收
                .eq(ObjIsNotEmpty.isNotEmpty(underCheck),"under_check",underCheck)
                //过滤条件：线上信息
                .eq(ObjIsNotEmpty.isNotEmpty(onlineCheck),"online_check",onlineCheck)
                //过滤条件：简历是否合格
                .eq(ObjIsNotEmpty.isNotEmpty(piResumeIsok),"pi_resume_isok",piResumeIsok)
                //过滤条件：等级
                .eq(StringUtils.isNotEmpty(piComprehensiveQuality),"pi_comprehensive_quality",piComprehensiveQuality);
        //过滤条件：项目验收
        if (underCheck != null && "通过".equals(underCheck)){
            queryWrapper.eq("under_check",1);
        }else if(underCheck != null && "不通过".equals(underCheck)){
            queryWrapper.eq("under_check",0);
        }
        //过滤条件：等级
        queryWrapper.eq(StringUtils.isNotEmpty(piComprehensiveQuality),"pi_comprehensive_quality",piComprehensiveQuality);
        return allScoreObjectMapper.selectAllScoreObjects(page,queryWrapper);
    }



    //学生项目

    /**
     * @param allScoreObject 批量插入ScoreObject
     * @return
     */

    /**
     * 通过学科方向,年份,班级id查询学生项目信息
     *
     * @param subtype 学科方向
     * @param year 年份
     * @param id 班级id
     * @param current 第几页
     * @return
     */
    public IPage<SubjectCheck> findAllSubjectCheckByCondition(String subtype, String year, Long id, Integer current) {
        //根据学科方向查出学科id
        if (subtype != null && subtype != ""){
            QueryWrapper<SubjectType> q1 = Wrappers.query();
            q1.eq("type_name",subtype).select("id");
            SubjectType subjectType = subjectTypeMapper.selectOne(q1);
            //获取学科的id
            Long subId = subjectType.getId();
        }
        Page<SubjectCheck> page = new Page<>(current,size);
        QueryWrapper<SubjectCheck> queryWrapper = Wrappers.query();
        queryWrapper.eq(StringUtils.isNotEmpty(year),"year",subtype);
        return subjectCheckMapper.selectPage(page,queryWrapper);
    }

    /**
     * 根据SubjectCheck id 查询
     *
     * @param id SubjectCheck id
     * @return 一条SubjectCheck记录
     */
    public SubjectCheck findAllSubjectCheckById(Long id) {
        return subjectCheckMapper.selectById(id);
    }


    /**
     * 编辑答辩项目
     *
     * @param subjectCheck 答辩项目对象
     * @return 是否成功
     */
    public boolean editSubjectCheckById(SubjectCheck subjectCheck) {
        subjectCheckMapper.updateById(subjectCheck);
        return true;
    }


    public List<Score> findScoresByStudentId(Long id) {
        QueryWrapper<Score> queryWrapper = Wrappers.query();
        queryWrapper.eq("s.s_id",id);
        return scoreMapper.findScoresByStudentId(queryWrapper);
    }








}
