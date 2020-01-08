package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.SearchItem;
import org.apache.ibatis.annotations.Param;

import javax.naming.Name;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
public interface SearchItemMapper extends BaseMapper<SearchItem> {

    IPage<SearchItem> selectQuestionByPageName(IPage<SearchItem> page ,@Param("name") String Name);
}
