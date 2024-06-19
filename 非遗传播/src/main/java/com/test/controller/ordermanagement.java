package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.pojo.commonreslut;
import com.test.pojo.orderform;
import com.test.pojo.product;
import com.test.pojo.users;
import com.test.service.orderformport;
import com.test.service.productport;
import com.test.service.usersport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//订单操作

@RestController
@RequestMapping("/com/ordermanagement")
public class ordermanagement {
    @Autowired
    private orderformport orderformport;
    @Autowired
    private usersport usersport;
    @Autowired
    private productport productport;
//    用户下单
    @PostMapping("/add")
    public commonreslut<orderform> orderformadd(orderform orderform){
        int code = 201;
        String msg = "下单失败";
        System.out.println(orderform);

        QueryWrapper<users> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",orderform.getUname());
        users users=usersport.getOne(wrapper);


        QueryWrapper<product> wrapper1=new QueryWrapper<>();
        wrapper1.eq("pid",orderform.getPid());
        product product= productport.getOne(wrapper1);

        orderform.setNumber(orderform.getNumber());
        orderform.setPhone(users.getPhone());
        orderform.setUaddress(users.getUaddress());
        orderform.setProductprice(product.getProductprice());

        System.out.println(orderform);

        if(users.getWallet()>=product.getProductprice()){
            users.setWallet(users.getWallet()-product.getProductprice());
            boolean a= orderformport.save(orderform);
            boolean b=usersport.updateById(users);
            if(a&&b){
                msg="下单成功";code=200;
                product.setSalenumber(product.getSalenumber()+orderform.getNumber());
                System.out.println(product);
                boolean c=productport.update(product,wrapper1);
            }else {

            }
        }else {
            msg="下单失败,余额不足";code=202;
        }


        commonreslut<orderform> commonreslut = new commonreslut<>(code, msg);
        return commonreslut;
    }
//    用户订单首页
    @PostMapping("/search")
    public commonreslut<List<orderform>> orderformsearch(orderform orderform){
        System.out.println(orderform);
        int code = 201;
        String msg = "查询错误";
        QueryWrapper<orderform> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",orderform.getUname());
        int i=orderformport.count(wrapper);
        if(i>=0){
            code=200;
            msg="查询到"+i+"条数据";
        }
        List<orderform> orderform1= orderformport.list(wrapper);
        commonreslut<List<orderform>> commonreslut = new commonreslut<>(code, msg,orderform1);
        return commonreslut;
    }
}
