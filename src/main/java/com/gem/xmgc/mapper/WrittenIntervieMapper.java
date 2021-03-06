package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.WrittenIntervie;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WrittenIntervieMapper extends BaseMapper<WrittenIntervie> {
    @Select("select wi.id,s.s_name,wi.f_score,wi.w_score from written_intervie wi join student s on wi.s_id = s.id ${ew.customSqlSegment} and s.statu = 0")
    public IPage<WrittenIntervie> findAllWrittenAndIntervie(Page<WrittenIntervie> page, @Param(Constants.WRAPPER) Wrapper<WrittenIntervie> queryWrapper);

}
