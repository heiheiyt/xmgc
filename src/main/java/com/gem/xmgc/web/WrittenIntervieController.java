package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.WrittenInterviewView;
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
@RequestMapping("/headTeacher/writtenIntervie")
@ResponseBody
public class WrittenIntervieController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping("/list")
    public IPage<WrittenInterviewView> getWrittenIntervieList(Long id, String studentName, Integer current){
        if (current == null){
            current = 1;
        }
        return scoreService.findAllWrittenAndInterviewView(id,studentName,current);
    }


    @RequestMapping("/find")
    public WrittenInterviewView getScoresByStudentId(Long id){
        return scoreService.findWrittenAndInterviewViewById(id);
    }

    @RequestMapping("/edit")
    public Boolean editWrittenAndIntervie(WrittenInterviewView writtenIntervie){
        System.out.println(writtenIntervie);
        return scoreService.editWrittenAndIntervie(writtenIntervie);
    }

    @RequestMapping("/downLoad")
    public String exportExcelTest(HttpServletResponse response, String type, String excel, String sheet, String excelName, Long cid) throws ClassNotFoundException {
        List<WrittenInterviewView> list = scoreService.findAllWrittenAndInterview(cid);
        UpDownUtil.exportExcel(response,type,list,excel,sheet,excelName);
        return "success";
    }

}
