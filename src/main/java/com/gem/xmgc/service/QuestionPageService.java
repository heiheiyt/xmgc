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
 * @author 张开
 * @date 2019/10/24 16:33
 */
@Service
public class QuestionPageService{
    @Autowired
    SearchPaperDetailMapper searchPaperDetailMapper;
    @Autowired
    SearchItemMapper searchItemMapper;
    @Autowired
    SearchPaperTypeMapper searchPaperTypeMapper;
    @Autowired
    SearchUseInfoMapper searchUseInfoMapper;
    //上传问卷题目表(searchitem实体类)
    /**
    * @author 张开
    * @date 2019/10/24 19:27
    * @description 给题目集合 创建问卷包含题目
    */
    public boolean updateQuestion(SearchItem searchItem) {
       searchItemMapper.updateById(searchItem);
       return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 19:28
    * @description 创建问卷发布计划(searchuseinfo实体类)
    */
    public boolean createQuestionPage(SearchUseInfo searchuseinfo) {
        searchUseInfoMapper.insert(searchuseinfo);
        return false;
    }

    public SearchPaperType searchPaperTypeByName(String name) {
        QueryWrapper<SearchPaperType> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("t_name",name);
        return searchPaperTypeMapper.selectOne(queryWrapper);
    }
    //查找所有问卷
    public List<SearchPaperType> searchAllPaperType() {

        return searchPaperTypeMapper.selectList(null);
    }
    @Autowired
    SearchPaperStatuMapper searchPaperStatuMapper;
    //查找所有问卷状态
    public List<SearchPaperStatu> searchPaperStatu() {
        return searchPaperStatuMapper.selectList(null);
    }
    public SearchPaperStatu searchPaperStatuById(Long id) {
        QueryWrapper<SearchPaperStatu> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return searchPaperStatuMapper.selectOne(queryWrapper);
    }
    @Autowired
    ClazzMapper clazzMapper;
    public IPage<SearchPaperType> findAllQuestionPage(Integer current) {
        Page<SearchPaperType> page = new Page<>(current,5);
        return searchPaperTypeMapper.selectSearchUseInfo(page);
    }
    //查询问卷详情
    public SearchPaperType findQuestionPageInfoById(Long id) {
        QueryWrapper<SearchPaperType> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return searchPaperTypeMapper.selectOne(queryWrapper);
    }
    /**
    * @author 张开
    * @date 2019/10/24 20:04
    * @description 通过班级查询问卷发布计划
    */
    public IPage<SearchUseInfo> findQuestionPageByClassId(long id) {
        Page<SearchUseInfo> page = new Page<>(1,5);
        QueryWrapper<SearchUseInfo> queryWrapper = Wrappers.<SearchUseInfo>query().eq("cid",id);
        return searchUseInfoMapper.selectPage(page,queryWrapper);

    }
    /**
    * @author 张开
    * @date 2019/10/24 20:13
    * @description 通过id查询问卷发布计划
    */
    public SearchUseInfo findQuestionPageById(Long id) {
        QueryWrapper<SearchUseInfo> queryWrapper = Wrappers.<SearchUseInfo>query().eq("id",id);
        return searchUseInfoMapper.selectOne(queryWrapper);
    }
    /**
    * @author 张开
    * @date 2019/10/24 21:00
    * @description 编辑问卷发布计划
    */
    public boolean editQuestionPage(SearchUseInfo searchuseinfo) {
        searchUseInfoMapper.update(searchuseinfo,null);
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 21:02
    * @description 删除问卷发布计划
    */
    public boolean removeQuestionPage(Long id) {
        searchUseInfoMapper.deleteById(id);
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/24 21:03
    * @description 根据问卷名查询题目(searchpaperdetail实体类)
     * @return
    */
    public IPage<SearchItem> fingQuestionitem(String name,Integer current) {
       return searchItemMapper.selectQuestionByPageName(new Page<>(current,5),name);
    }
    public SearchItem fingQuestionitemById(Long id) {
        return searchItemMapper.selectById(id);
    }
    /**
    * @author 张开
    * @date 2019/10/25 11:13
    * @description 编辑问卷题目
    */
    public boolean editQuestionItem(SearchItem searchitem) {
       searchItemMapper.update(searchitem,null);
       return true;
    }
    //根据题目ID查询题目详情
    public SearchItem QuestionItemDetail(Long id) {
        return searchItemMapper.selectById(id);
    }
    //上传问卷题目
    public boolean editQuestionItems(SearchItem searchitem) {
        searchItemMapper.insert(searchitem);
        return true;
    }
    public boolean editQuestiondetaill(SearchPaperDetail searchPaperDetail) {
        searchPaperDetailMapper.insert(searchPaperDetail);
        return true;
    }
    /**
    * @author 张开
    * @date 2019/10/25 11:18
    * @description 删除问卷题目
    */
    public boolean removeQuestionItem(Long id) {
    searchItemMapper.deleteById(id);
        return true;
    }
    //添加问卷
    public int addQuestion(SearchPaperType searchPaperType){
        return searchPaperTypeMapper.insert(searchPaperType);
    }
}
