package com.gem.xmgc.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.gem.xmgc.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableTransactionManagement
public class ManagerConfig implements WebMvcConfigurer {
    @Autowired
    MyInterceptor myInterceptor;
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //管理员登录...
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/l/login").setViewName("manager/Adminindex");
        registry.addViewController("/lala").setViewName("manager/commons");
        registry.addViewController("/manager/welcome").setViewName("manager/welcome");
        registry.addViewController("/list/manageradd").setViewName("manager/managerEdit_add");
        registry.addViewController("/list/newSubject").setViewName("manager/newSubject");
        registry.addViewController("/list/subjectadd").setViewName("manager/newSubject_add");
        registry.addViewController("/list/manageremailcc").setViewName("manager/managerEdit");
        registry.addViewController("/list/allShow").setViewName("manager/allShow");
        registry.addViewController("/l/loginxmadmin").setViewName("xmgcmanager/Adminindex");
        registry.addViewController("/xmgclist/v/showAllScore").setViewName("xmgcmanager/showAllScore");
        registry.addViewController("/xmgclist/v/ansProject").setViewName("xmgcmanager/ansProject");

        registry.addViewController("/xmgclist/v/showAllJY").setViewName("xmgcmanager/jy-list-v");

        //教务
        registry.addViewController("/SecondModualAdd").setViewName("jw/SecondModualAdd");
        registry.addViewController("/modualAdd").setViewName("jw/modualAdd");
        registry.addViewController("/upload").setViewName("jw/upload");
        registry.addViewController("/l/loginjw").setViewName("jw/registrarindex");
        registry.addViewController("/jw/welcome").setViewName("jw/welcome");
        //实训师

        registry.addViewController("/l/loginsxs").setViewName("sxs/Trainer-index");
       /* registry.addViewController("/sxs/welcome").setViewName("sxs/Trainer-welcome");*/
        registry.addViewController("/paper/v/view").setViewName("sxs/Trainer-list");
        registry.addViewController("/paper/v/exam").setViewName("sxs/Trainer-paperlist");
        registry.addViewController("/task/v/view").setViewName("sxs/Trainer-taskview");
        registry.addViewController("/task/v/upload").setViewName("sxs/Trainer-taskupload");
        registry.addViewController("/class/v/current").setViewName("sxs/Trainer-current");
        registry.addViewController("/class/v/employment").setViewName("sxs/bm-score-list-w");
        registry.addViewController("/class/v/writtenresult").setViewName("sxs/all-score-list-v");
        registry.addViewController("/paper/title/v/detail").setViewName("sxs/Trainer-titledetail");
        registry.addViewController("/paper/title/v/time").setViewName("sxs/Trainer-papertime");
        registry.addViewController("/task/v/taskedit").setViewName("sxs/Trainer-taskedit");
        registry.addViewController("/task/v/detail").setViewName("sxs/Trainer-taskdetail");
        registry.addViewController("/task/v/changetime").setViewName("sxs/Trainer-tasktime");
        registry.addViewController("/paper/v/paperedit").setViewName("sxs/Trainer-paperedit");
        registry.addViewController("/task/v/add").setViewName("sxs/Trainer-tasklistadd");


        //班主任

        registry.addViewController("/l/loginbzr").setViewName("bzr/bzr-index");
        registry.addViewController("/headTeacher/welcome").setViewName("bzr/bzr-welcome");
        registry.addViewController("/headTeacher/da-list").setViewName("bzr/da-list");
        registry.addViewController("/headTeacher/da-add").setViewName("bzr/da-add");
        registry.addViewController("/headTeacher/da-details").setViewName("bzr/da-details");
        registry.addViewController("/headTeacher/wj-list").setViewName("bzr/wj-list");
        registry.addViewController("/headTeacher/wj-add").setViewName("bzr/wj-add");
        registry.addViewController("/headTeacher/wj-details").setViewName("bzr/wj-details");
        registry.addViewController("/headTeacher/cs-score-list-v").setViewName("bzr/cs-score-list-v");
        registry.addViewController("/headTeacher/cs-details").setViewName("bzr/cs-details");
        registry.addViewController("/headTeacher/bm-score-list-w").setViewName("bzr/bm-score-list-w");
        registry.addViewController("/headTeacher/all-score-list-v").setViewName("bzr/all-score-list-v");
        registry.addViewController("/headTeacher/jy-list-v").setViewName("bzr/jy-list-v");
        registry.addViewController("/headTeacher/zh-list-v").setViewName("bzr/zh-list-v");
        registry.addViewController("/headTeacher/zh-details").setViewName("bzr/zh-details");
        registry.addViewController("/headTeacher/upload").setViewName("bzr/upload");
        registry.addViewController("/headTeacher/wj-edit").setViewName("bzr/wj-edit");
        registry.addViewController("/headTeacher/bm-edit").setViewName("bzr/bm-edit");
        registry.addViewController("/headTeacher/zh-add").setViewName("bzr/zh-add");


    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/list/**","/l/**");
                //.excludePathPatterns("/login","/account/**","/static/**");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

   }
