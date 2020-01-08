package com.gem.xmgc.web;


import com.gem.xmgc.entity.Clazz;
import com.gem.xmgc.entity.Student;
import com.gem.xmgc.entity.Teacher;
import com.gem.xmgc.entity.UsePaper;
import com.gem.xmgc.mapper.ClazzMapper;
import com.gem.xmgc.service.ClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yt
 * @date 2019/10/28 13:58
 */
@RestController
@RequestMapping("/clazz")
public class SxsClazzController {
    @Autowired
    ClazzServiceImpl clazzService;
    @Autowired
    ClazzMapper clazzMapper;
    @GetMapping("/view")
    //实训师接入口！！！
    public List<Clazz> ClazzView(HttpSession session){
        /**
         * 实训师id接入口
         */
        /*tid=18L;
        session.setAttribute("tid",tid);*/
        Long tid = (Long) session.getAttribute("tid");
        System.err.println("实训师id="+tid);

        return clazzService.findClazzByTeacherId(tid);
    }
    @PostMapping("/choose")
    public void ClazzChoose(Long cid, HttpSession session){
        session.setAttribute("cid",cid);
    }
}
