package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.WrittenInterviewView;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张开
 * @date 2019/11/7 14:09
 */
public interface WrittenInterviewViewMapper extends BaseMapper<WrittenInterviewView> {

    @Select("select wi.id,s.s_name,wi.f_score,wi.w_score from written_intervie wi join student s on wi.s_id = s.id ${ew.customSqlSegment} and s.statu = 0")
    public IPage<WrittenInterviewView> findAllWrittenAndIntervie(Page<WrittenInterviewView> page, @Param(Constants.WRAPPER) Wrapper<WrittenInterviewView> queryWrapper);
    @Select("select wi.id,s.s_name,wi.f_score,wi.w_score from written_intervie wi join student s on wi.s_id = s.id ${ew.customSqlSegment} and s.statu = 0")
    public List<WrittenInterviewView> findAllWrittenAndInterview(@Param(Constants.WRAPPER) Wrapper<WrittenInterviewView> queryWrapper);
}
