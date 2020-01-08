package com.gem.xmgc.interceptor;

import com.gem.xmgc.entity.AccountAll;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 张开
 * @date 2019/11/5 11:37
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        AccountAll accountAll = (AccountAll) session.getAttribute("AccountAll");
        if(accountAll==null){
            response.sendRedirect(request.getContextPath()+"/login?info=1");
            return false;
        }
        return true;
    }
}
