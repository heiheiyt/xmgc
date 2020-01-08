package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.xmgc.entity.PaperDetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张开
 * @date 2019/10/23 20:49
 */
public interface PaperDetailMapper extends BaseMapper<PaperDetail> {
    @Select("select t_id from paperdetail where p_id=#{pid}")
    List<Integer> selectTitleListById(Long pid);
}
