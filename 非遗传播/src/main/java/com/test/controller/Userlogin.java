package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.pojo.commonreslut;
import com.test.pojo.users;
import com.test.service.usersport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/com/userlogin")
public class Userlogin {
    @Autowired
    private usersport usersport;

//用户登录
    @PostMapping("/login")
    public commonreslut<users> login(users users, HttpServletRequest request, HttpServletResponse response){
        System.out.println("用户输入："+users);
        boolean a = false;
        String msg;
        int code;
        QueryWrapper<users> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",users.getUname());
        int i= usersport.count(wrapper);
        if(i==1){
            wrapper.eq("upwd",users.getUpwd());
            int j= usersport.count(wrapper);
            if(j==1){
                a=true;msg="用户存在，密码正确，登录成功";code=200;
            }else{
                msg="密码错误";code=201;
            }
        }else {
            msg="没有该账号";code=202;
        }
        System.out.println("登录结果为："+a);
        HttpSession session= request.getSession();
        if(a){session.setAttribute("userdlzt","ture");}
        commonreslut<users> commonreslut = new commonreslut<>(code, msg);
        return commonreslut;
    }
//    用户注册
    @PostMapping("/register")
    public commonreslut<users> register(users users){
        System.out.println(users);
        int code;
        String msg;
        QueryWrapper<users> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",users.getUname());
        int i= usersport.count(wrapper);
        if(i==1){
            msg="注册失败，该用户名已存在";code=201;
        }else {
            boolean a= usersport.save(users);
            if(a){
                msg="注册成功";code=200;
            }else {
                msg="注册失败";code=202;
            }
        }
        commonreslut<users> commonreslut = new commonreslut<>(code, msg);
        return commonreslut;
    }

}
