package com.test.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class interceptortest implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器=======执行前========");
//        // 记录访问IP的次数逻辑
//        // 获取访问的IP
//        String ip = request.getRemoteAddr();
//        // 统计访问次数并输出
//        HttpSession session = request.getSession();
//        Integer count = (Integer) session.getAttribute("count");
//        count = Objects.isNull(count) ? 1 : ++count;
//        System.out.println("此用户ip:" + ip + "\tcount:" + count);
//        session.setAttribute("count", count);
//        // 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入拦截器=======执行中========");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("进入拦截器=======执行后========");
    }
}
