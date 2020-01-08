package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.RecruitDetail;
import com.gem.xmgc.entity.RecruitInfo;
import com.gem.xmgc.entity.UseRecruit;
import com.gem.xmgc.mapper.RecruitDetailMapper;
import com.gem.xmgc.mapper.RecruitInfoMapper;
import com.gem.xmgc.mapper.UseRecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
     * 招生考试service(useRecruit 实体类(复合表封装)
     */
@Service
public class RecruitStudentTestService {
        //查找所有招生考试计划
    @Autowired
    UseRecruitMapper useRecruitMapper;
    public IPage<UseRecruit> findAllRecruitStudentTest(Integer current){
        Page<UseRecruit> page=new Page<>(current,5);
       return useRecruitMapper.selectPage(page,null);
        };
    //根据计划ID查找招生计划
    public UseRecruit findAllRecruitStudentTestById(Long id){
        QueryWrapper<UseRecruit> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return useRecruitMapper.selectOne(queryWrapper);
    };
        //修改招生考试计划(需要ID)
        public boolean editRecruitStudentTest(UseRecruit userecruit){
           useRecruitMapper.updateById(userecruit);
            return true;
        };
        @Autowired
    RecruitDetailMapper recruitDetailMapper;
        //根据试卷id称查找试卷题目
        public IPage<RecruitDetail> findRecruitStudentItemByName(Integer current,Long id){
            Page<RecruitDetail> page=new Page<>(current,5);
            QueryWrapper<RecruitDetail> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("r_id",id);
            return   recruitDetailMapper.selectPage(page,queryWrapper);
        };


        //查找所有试卷
    @Autowired
        RecruitInfoMapper recruitInfoMapper;
    public List<RecruitInfo> findAllRecruitInfo(){
        return recruitInfoMapper.selectList(null);
    };
    public RecruitInfo findAllRecruitInfoById(Long id){
        QueryWrapper<RecruitInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return recruitInfoMapper.selectOne(queryWrapper);
    };
    public RecruitInfo findRecruitInfoByName(String id){
        QueryWrapper<RecruitInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("r_name",id);
        return recruitInfoMapper.selectOne(queryWrapper);
    };
        //根据招生考试题目id删除题目
        public boolean recruitStudentItemById(Long id){
            recruitDetailMapper.deleteById(id);
            return true;
        };
        //模糊匹配招生试卷
        public List<RecruitInfo> findAllRecruitInfoBy(String subject){
            QueryWrapper<RecruitInfo> queryWrapper=new QueryWrapper<>();
            queryWrapper.like("r_name","%-"+subject);
            return recruitInfoMapper.selectList(queryWrapper);
        };

        //创建招生考试（insert UseRecruit）
        public boolean createUseRecruit(UseRecruit useRecruit){
            useRecruitMapper.insert(useRecruit);
            return true;
        };
        //修改招生考试题目(含Id)
        public int editRecruitDetail(RecruitDetail recruitDetail){
                return recruitDetailMapper.updateById(recruitDetail);
        };

        //根据id查询招生考试题目
        public RecruitDetail findRecruitDetailById(Long id){
            return recruitDetailMapper.selectById(id);
        };

        //添加招生题目
        public boolean uploadRecruitStudentItem(RecruitDetail recruitDetail){
            recruitDetailMapper.insert(recruitDetail);
            return true;
        };
        //添加招生试卷
    public boolean createRecruitStudentItem(RecruitInfo recruitInfo){
        recruitInfoMapper.insert(recruitInfo);
        return true;
    };
        //上传招生考试试卷(题目)(recruitdetail实体类)
//        public boolean uploadRecruitStudentItem(String filename, List<RecruitDetail> items);

    }