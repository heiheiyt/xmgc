package com.gem.xmgc.web;

import com.gem.xmgc.entity.Clazz;
import com.gem.xmgc.service.ClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author jiowww
 * @data 2019/10/28.
 */
@Controller
@RequestMapping("/headTeacher")
@ResponseBody
public class ClazzController {
    @Autowired
    ClazzServiceImpl clazzService;

    @RequestMapping("/clazz")
    public List<Clazz> getClazzByHeadTeacher(HttpSession session) {
        return clazzService.findClazzByManageId((Long) session.getAttribute("mid"));
    }

    @RequestMapping("/clazzOne")
    public Clazz getClazzById(Long id) {
        System.out.println(id==null);
        System.out.println("拿到的id=" + id);
        return clazzService.getClazzById(id);
    }
}
