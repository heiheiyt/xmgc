package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.SearchPaperType;

/**
 * @author jiowww
 * @data 2019/10/23.
 */
public interface SearchPaperTypeMapper extends BaseMapper<SearchPaperType> {
    IPage<SearchPaperType> selectSearchUseInfo(IPage<SearchPaperType> iPage);


}
