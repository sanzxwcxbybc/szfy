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

//管理员操作
@RestController
@RequestMapping("/com/userdatamanage")
public class Usersdatamanage {
    @Autowired
    private usersport usersport;
    @PostMapping("/update")
    public commonreslut<users> usersupdate(users users){
        QueryWrapper<users> wrapper=new QueryWrapper<>();
        wrapper.eq("id",users.getId());
        users.setWallet(usersport.getOne(wrapper).getWallet());
        System.out.println(users);
        int code = 201;
        String msg = "修改失败";
        boolean a=usersport.updateById(users);
        if(a){
            msg="修改成功";code=200;
        }
        commonreslut<users> commonreslut = new commonreslut<>(code, msg);
        return commonreslut;
    }
    @PostMapping("/search")
    public commonreslut<users> login(users users, HttpServletRequest request, HttpServletResponse response){
        System.out.println("用户输入："+users);
        String msg;
        int code;
        QueryWrapper<users> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",users.getUname());
        int i= usersport.count(wrapper);
        users users1=new users();
        if(i==1){
            users1=usersport.getOne(wrapper);
            msg="账号信息";code=200;
        }else {
            msg="没有该账号";code=201;
        }
        commonreslut<users> commonreslut = new commonreslut<>(code, msg,users1);
        return commonreslut;
    }
}
