package com.gem.xmgc.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.entity.PaperInfo;
import com.gem.xmgc.entity.TitleList;
import com.gem.xmgc.entity.UsePaper;
import com.gem.xmgc.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/paper")
public class SxsPaperController {
    @Autowired
    PaperService paperService;
    @ResponseBody
    @GetMapping("/view")
    public IPage PaperView(Integer current, HttpSession session,String time){
        Long tid= (Long) session.getAttribute("tid");
        Long cid = (Long) session.getAttribute("cid");
        //清空session
        IPage<UsePaper> usePaperIPage;
        if (current==null){
            current=1;
        }
        if (cid==null){
            usePaperIPage=paperService.findAllPaperByTeacherId(tid,time,null,current);
        }
        else {
           usePaperIPage=paperService.findAllPaperByClassId(cid,time,null,current);
        }
        usePaperIPage.getRecords().forEach(System.out::println);
        return usePaperIPage;
    }
    @ResponseBody
    @GetMapping("/list")
    public IPage<PaperInfo> PaperList(Integer current, HttpSession session,String time){
        Long tid= (Long) session.getAttribute("tid");
        Long cid = (Long) session.getAttribute("cid");
        IPage<PaperInfo> paperInfoIPage;
        if (current==null){
            current=1;
        }
        if (cid==null){
            paperInfoIPage = paperService.findAllPaperInfoByTeacherId(tid,time,current);
        }
        else{
            paperInfoIPage = paperService.findAllPaperInfoByClassId(cid,time,current);
        }
        return paperInfoIPage;
    }
    @ResponseBody
    @DeleteMapping("/paperdelete")
    public int PaperDelete(Long pid){
        return paperService.removePaperInfoById(pid);
    }
    @GetMapping("/title/detail/{paperId}")
    public String TitleDetail(@PathVariable("paperId") Long id,Model model,HttpSession session){
        //id获取到题目id
        session.setAttribute("paperId",id);
        List<TitleList> titleList = paperService.findTitleListById(id);
        model.addAttribute("titleList",titleList);
        return "sxs/Trainer-titledetail";
    }
    @GetMapping("/title/time/{usePaperId}")
    public String TiTleTime(@PathVariable("usePaperId") Long id,HttpSession session){
        session.setAttribute("usePaperId",id);
        return "sxs/Trainer-papertime";
    }
    @ResponseBody
    @GetMapping("/title/timeEdit")
    public Integer TitleEdit(String startTime , String endTime , HttpSession session){
        Long id = (Long) session.getAttribute("usePaperId");

        return paperService.editPaperTime(id,startTime,endTime);
    }
}
