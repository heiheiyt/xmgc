package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.TitleList;

import java.util.List;


public interface TitleListMapper extends BaseMapper<TitleList> {
    IPage<TitleList> selectTitleByPId(IPage<TitleList> page, Long id);
    List<TitleList> selectTitleById(Long id);
}
