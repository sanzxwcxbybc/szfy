package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.pojo.commonreslut;
import com.test.pojo.product;
import com.test.service.productport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/com/search")
public class productsearch {
    @Autowired
    private productport productport;
//    首页推荐
    @GetMapping("/indexrecommend/{p}")
    public commonreslut<Page<product>> indexrecommend(@PathVariable("p") int p,HttpServletRequest request, HttpServletResponse response){
        QueryWrapper<product> wrapper=new QueryWrapper<>();
        System.out.println("p="+p);
//        p=(p-1)*5;
        Page<product> page =new Page<>(p,5);
        Page<product> productspage=productport.page(page,wrapper);
        System.out.println(productspage);
        commonreslut<Page<product>> commonreslut = new commonreslut<>(200, "查询成功",productspage);
        return commonreslut;


    }
//用户搜索
    @GetMapping("/usersearch/{productname}/{p}")
    public commonreslut<Page<product>> search(@PathVariable("p") int p, @PathVariable("productname") String productname ){
        System.out.println("用户输入："+productname);
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<product> wrapper=new QueryWrapper<>();
        wrapper.like("productname",productname);
        System.out.println("p="+p);
        Page<product> page =new Page<>(p,5);
        Page<product> productspage=productport.page(page,wrapper);
        commonreslut<Page<product>> commonreslut = new commonreslut<>(200, "查询成功",productspage);
        return commonreslut;
    }

}
