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
@RequestMapping("/com/classifysearch")
public class classifysearch {
    @Autowired
    private productport productport;

    @GetMapping("/type1/{p}")
    public commonreslut<Page<product>> searchtype1(@PathVariable("p") int p){
        System.out.println("用户查询商品分类为：type1");
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<product> wrapper=new QueryWrapper<>();
        wrapper.like("productname","傩面");
        System.out.println("p="+p);
        Page<product> page =new Page<>(p,5);
        Page<product> productspage=productport.page(page,wrapper);
        commonreslut<Page<product>> commonreslut = new commonreslut<>(200, "查询成功",productspage);
        return commonreslut;
    }
    @GetMapping("/type2/{p}")
    public commonreslut<Page<product>> searchtype2(@PathVariable("p") int p){
        System.out.println("用户查询商品分类为：type2");
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<product> wrapper=new QueryWrapper<>();
        wrapper.like("productname","西兰卡普");
        System.out.println("p="+p);
        Page<product> page =new Page<>(p,5);
        Page<product> productspage=productport.page(page,wrapper);
        commonreslut<Page<product>> commonreslut = new commonreslut<>(200, "查询成功",productspage);
        return commonreslut;
    }
    @GetMapping("/type3/{p}")
    public commonreslut<Page<product>> searchtype3(@PathVariable("p") int p){
        System.out.println("用户查询商品分类为：type3");
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<product> wrapper=new QueryWrapper<>();
        wrapper.like("productname","肉连响");
        System.out.println("p="+p);
        Page<product> page =new Page<>(p,5);
        Page<product> productspage=productport.page(page,wrapper);
        commonreslut<Page<product>> commonreslut = new commonreslut<>(200, "查询成功",productspage);
        return commonreslut;
    }

}