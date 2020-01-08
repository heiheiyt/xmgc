package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yt
 * @date 2019/10/24 8:51
 */
@Service
@EnableAutoConfiguration
public class PaperService {

    @Autowired
    public UsePaperMapper usePaperMapper;
    @Autowired
    public PaperInfoMapper paperInfoMapper;
    @Autowired
    public PaperDetailMapper paperDetailMapper;
    @Autowired
    public TitleListMapper titleListMapper;

    //查询所有考试计划(usepaper 实体类)
    public IPage<UsePaper> findAllPaper(Integer current) {
        Page<UsePaper> page = new Page<>(current,5);
        return usePaperMapper.selectAllPaper(page);
    }
    /**
     *  新增
     *  通过实训师id查询考试数量
     * @param tid
     * @return
     */
    public List<UsePaper> findPapers(Long tid){
        return usePaperMapper.selectPaper(tid);
    }

    /**
     * 新增
     * 通过班级ID日期和考试名称查询所有考试计划
     * @param cid
     * @param current
     * @return
     */
    public IPage<UsePaper> findAllPaperByClassId(Long cid,String time,String name,Integer current) {
        Page<UsePaper> page = new Page<>(current,5);
        /*        LambdaQueryWrapper<UsePaper> queryWrapper = Wrappers.<UsePaper>lambdaQuery().eq(UsePaper::getCId,id);*/
        return usePaperMapper.selectByClassId(page,cid,time,name);
    }

    /**
     * 新增
     * 通过实训师id查询所以考试计划
     * @param tid
     * @param time
     * @param name
     * @param current
     * @return
     */
    public IPage<UsePaper> findAllPaperByTeacherId(Long tid,String time,String name,Integer current){
        Page<UsePaper> page = new Page<>(current,5);
        return usePaperMapper.selectByTeacherId(page,tid,time,name);
    }


    //更新考试计划时间
    public int editPaperTime(Long id,String startTime,String endTime){

        String ymd = usePaperMapper.selectPaperTimeById(id);
        System.out.println(ymd);
        return usePaperMapper.updataTimeById(ymd+" ",startTime,endTime,id);
    }

    //根据试卷id 查询题目(titlelist实体类(题库) ,paperdetail实体类(中间表))

    public List<TitleList> findTitleListById(Long id) {
        //通过题目id查询题目详情
        return titleListMapper.selectTitleById(id);
    }

    //编辑题库中的一个题目

    public int editTitleList(TitleList titlelist) {
        return titleListMapper.updateById(titlelist);
    }





    public IPage<UsePaper> findPaperByClassId(Long id,Integer current) {
        Page<UsePaper> page = new Page<>(current,5);
        /*        LambdaQueryWrapper<UsePaper> queryWrapper = Wrappers.<UsePaper>lambdaQuery().eq(UsePaper::getCId,id);*/
        return usePaperMapper.selectPaperByOhter(page,id,null,null);
    }
    //通过日期和考试名称查询考试计划

    public IPage<UsePaper> findPaperByDateAndName(Long id, String time, String name, Integer current) {
        Page<UsePaper> page = new Page<>(current,5);
        return usePaperMapper.selectPaperByOhter(page,id,time,name);
    }
    //编辑班级考试试卷

    public int editPaper(UsePaper usepaper) {
        return usePaperMapper.updateById(usepaper);
    }

    //根据试卷id 查询题目(titlelist实体类(题库) ,paperdetail实体类(中间表))

    public IPage<TitleList> findTitleListById(Long id , Integer current) {
        Page<TitleList> page = new Page<>(current,5);
       //通过题目id查询题目详情
        return titleListMapper.selectTitleByPId(page,id);
    }

    //根据试卷id和试卷中某一题id删除试卷中的某一题

    public int removePaperDetailById(Long pid, Long tid) {
        LambdaQueryWrapper<PaperDetail> queryWrapper = Wrappers.<PaperDetail>lambdaQuery().eq(PaperDetail::getPId,pid).eq(PaperDetail::getTId,tid);
        return paperDetailMapper.delete(queryWrapper);
    }

    //通过班级id查询所有的试卷名称

    public IPage<PaperInfo> findAllPaperinfoByClassId(Long id ,Integer current) {
        //先根据usepaper表中班级id获取到试卷id集合
        Page<PaperInfo> page = new Page<>(current,5);
         return paperInfoMapper.selectPaperByClassId(page,id);
    }
    //通过班级id查询所有的试卷名称

    public IPage<PaperInfo> findAllPaperInfoByClassId(Long id,String time,Integer current) {
        //先根据usepaper表中班级id获取到试卷id集合
        Page<PaperInfo> page = new Page<>(current,5);
        return paperInfoMapper.selectPaperByClassId(page,time,id);
    }

    public int removePaperInfoById(Long id){
        return paperInfoMapper.deleteById(id);
    }
    public IPage<PaperInfo> findAllPaperInfoByTeacherId(Long id,String time,Integer current){
        Page<PaperInfo> page = new Page<>(current,5);
        return paperInfoMapper.selectPaperByTeacherId(page,time,id);
    }
}
