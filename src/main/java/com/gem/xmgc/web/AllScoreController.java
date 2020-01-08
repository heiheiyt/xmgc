package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.AllScoreObject;
import com.gem.xmgc.service.ScoreService;
import com.gem.xmgc.util.UpDownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 违纪控制器
 * @author jiowww
 * @data 2019/10/28.
 */
@Controller
@RequestMapping("/headTeacher/allScore")
@ResponseBody
public class AllScoreController {

  @Autowired
  ScoreService scoreService;

    @RequestMapping("/list")
    public IPage<AllScoreObject> getWrittenIntervieList(Long id, Integer current){
        if (current == null){
            current = 1;
        }
        return scoreService.findAllResult(id,current);
    }

    @RequestMapping("/search")
    public IPage<AllScoreObject> getWrittenIntervieListByCondition(Long id, String studentName, String face, String write,Integer project, Integer online, Integer resume, String level){
        return scoreService.findAllScoreObject(id,studentName,face,write,project,online,resume,level,1);
    }


    @RequestMapping("/downLoad")
    public String exportExcelTest(HttpServletResponse response, String type, String excel, String sheet, String excelName, Long cid) throws ClassNotFoundException {
        List<AllScoreObject> list = scoreService.findAllScoreObject(cid);
        list.forEach(System.out::println);
        UpDownUtil.exportExcel(response,type,list,excel,sheet,excelName);
        return "success";
    }


}
