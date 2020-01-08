package com.gem.xmgc.web;

import com.gem.xmgc.entity.ScoreView;
import com.gem.xmgc.entity.StudentScore;
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
@RequestMapping("/headTeacher/score")
@ResponseBody
public class ScoreController {

    @Autowired
    ScoreService scoreService;


    @RequestMapping("/find")
    public List<ScoreView> getScoresByStudentId(Long id){
        return scoreService.findScoresViewByStudentId(id);
    }


    @RequestMapping("/downLoad")
    public String exportExcelTest(HttpServletResponse response, String type, String excel, String sheet, String excelName, Long cid) throws ClassNotFoundException {
        List<StudentScore> list = scoreService.findAllStudentScore(cid);
        UpDownUtil.exportExcel(response,type,list,excel,sheet,excelName);
        return "success";
    }
}
