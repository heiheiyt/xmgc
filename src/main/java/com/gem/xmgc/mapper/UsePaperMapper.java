package com.gem.xmgc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.UsePaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface UsePaperMapper extends BaseMapper<UsePaper> {
    IPage<UsePaper> selectAllPaper(IPage<UsePaper> iPage);

    IPage<UsePaper> selectPaperByOhter(IPage<UsePaper> iPage, @Param("id") Long id, @Param("time") String time, @Param("name") String name);

    int updataTimeById(String ymd,String startTime,String endTime,Long id);

    String selectPaperTimeById(Long id);

    /**
     *以下为新增
     */
    IPage<UsePaper> selectByClassId(IPage<UsePaper> iPage,Long id,String time,String name);
    IPage<UsePaper> selectByTeacherId(IPage<UsePaper> iPage,Long id,String time,String name);

    @Select("select u.* from usepaper u where u.c_id in\n" +
            "(select c_id from t_class where t_id=#{id}) and u.statu=0\n")
    List<UsePaper> selectPaper(Long id);
}
