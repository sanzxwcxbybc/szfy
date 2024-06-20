package com.test.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.pojo.log;
import com.test.service.logport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Component
public class interceptortest implements HandlerInterceptor {
    @Autowired
    private logport logport;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器=======执行前========");
        log log=new log();
        // 记录访问IP的次数逻辑
        // 获取访问的IP
        log.setRequestip(request.getRemoteAddr());
//        端口
        log.setRequestport(request.getRemotePort());
//        主机名
        log.setRequestpcname(request.getRemoteHost());
//        访问地址
        log.setRequesturl(String.valueOf(request.getRequestURL()));

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-DD hh:mm:ss");
        System.out.println(dateTime.format(formatter)); //指定格式输出
        //System.out.println(dateTime);                   //默认格式输出
//        用户访问时间
        log.setRequestdate(dateTime.format(formatter));

        String ip = request.getRemoteAddr();
        // 统计访问次数并输出
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        count = Objects.isNull(count) ? 1 : ++count;
        System.out.println("此用户ip:" + ip + "\tcount:" + count);
        System.out.println(log);
        session.setAttribute("count", count);

        QueryWrapper<log> wrapper=new QueryWrapper<>();
        logport.save(log);

//        预防爬虫或DOS攻击
        if(count>999){
            return false;
        }


        // 放行
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
