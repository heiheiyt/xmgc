package com.gem.xmgc.controllerCRM;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.xmgc.CRMentity.JobAPI;
import com.gem.xmgc.util.SendUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author 张开
 * @date 2019/11/11 10:45
 */
@Controller
@RequestMapping("/JobAPI")
public class JobAPIController {
    @PostMapping("/select")
    @ResponseBody
    public List<JobAPI> selectAllJobAPI(Integer currentpage){
        if(currentpage==null){
            currentpage=1;
        }
        List<JobAPI> list = SendUtil.send("/selectAllJobAPI/"+currentpage);
        return list;
    }

}
