package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.PaperInfo;

/**
 * @author 张开
 * @date 2019/10/23 20:50
 */
public interface PaperInfoMapper extends BaseMapper<PaperInfo> {
   IPage<PaperInfo> selectPaperByClassId(IPage<PaperInfo> page, Long id);
   IPage<PaperInfo> selectPaperByClassId(IPage<PaperInfo> page,String time,Long id);
   IPage<PaperInfo> selectPaperByTeacherId(IPage<PaperInfo> page,String time,Long id);
}
