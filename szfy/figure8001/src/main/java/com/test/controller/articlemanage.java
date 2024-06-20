package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.pojo.article;
import com.test.pojo.commonreslut;
import com.test.service.articleport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/article")
public class articlemanage {
    @Autowired
    private articleport articleport;
//    文章数据
    //搜索
@GetMapping("/search/typeall/{textname}/{p}")
    public commonreslut<Page<article>> searchAll(@PathVariable("p") int p,@PathVariable("textname") String textname){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<article> wrapper=new QueryWrapper<>();
        wrapper.like("textname",textname);
        System.out.println("p="+p);
        Page<article> page =new Page<>(p,5);
        Page<article> articlepage=articleport.page(page,wrapper);
        commonreslut<Page<article>> commonreslut = new commonreslut<>(200, "查询成功",articlepage);
        return commonreslut;
    }

//    政策
    @GetMapping("/search/type1/{p}")
    //    特殊获取路径上参数@PathVariable,普通就全去了/search/type1,int p
    public commonreslut<Page<article>> searchtype1(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<article> wrapper=new QueryWrapper<>();
        wrapper.eq("texttype",1);
        System.out.println("p="+p);
        Page<article> page =new Page<>(p,5);
        Page<article> articlepage=articleport.page(page,wrapper);
        commonreslut<Page<article>> commonreslut = new commonreslut<>(200, "查询成功",articlepage);
        return commonreslut;
    }
//    旅游文化
    @GetMapping("/search/type2/{p}")
    public commonreslut<Page<article>> searchtype2(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<article> wrapper=new QueryWrapper<>();
        wrapper.eq("texttype",2);
        System.out.println("p="+p);
        Page<article> page =new Page<>(p,5);
        Page<article> articlepage=articleport.page(page,wrapper);
        commonreslut<Page<article>> commonreslut = new commonreslut<>(200, "查询成功",articlepage);
        return commonreslut;
    }
//    非遗文化
    @GetMapping("/search/type3/{p}")
    public commonreslut<Page<article>> searchtype3(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<article> wrapper=new QueryWrapper<>();
        wrapper.eq("texttype",3);
        System.out.println("p="+p);
        Page<article> page =new Page<>(p,5);
        Page<article> articlepage=articleport.page(page,wrapper);
        commonreslut<Page<article>> commonreslut = new commonreslut<>(200, "查询成功",articlepage);
        return commonreslut;
    }
//    土家民俗文化
    @GetMapping("/search/type4/{p}")
    public commonreslut<Page<article>> searchtype4(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<article> wrapper=new QueryWrapper<>();
        wrapper.eq("texttype",4);
        System.out.println("p="+p);
        Page<article> page =new Page<>(p,5);
        Page<article> articlepage=articleport.page(page,wrapper);
        commonreslut<Page<article>> commonreslut = new commonreslut<>(200, "查询成功",articlepage);
        return commonreslut;
    }
//    革命文化
    @GetMapping("/search/type5/{p}")
    public commonreslut<Page<article>> searchtype5(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<article> wrapper=new QueryWrapper<>();
        wrapper.eq("texttype",5);
        System.out.println("p="+p);
        Page<article> page =new Page<>(p,5);
        Page<article> articlepage=articleport.page(page,wrapper);
        commonreslut<Page<article>> commonreslut = new commonreslut<>(200, "查询成功",articlepage);
        return commonreslut;
    }
//    硒文化
    @GetMapping("/search/type6/{p}")
    public commonreslut<Page<article>> searchtype6(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<article> wrapper=new QueryWrapper<>();
        wrapper.eq("texttype",6);
        System.out.println("p="+p);
        Page<article> page =new Page<>(p,5);
        Page<article> articlepage=articleport.page(page,wrapper);
        commonreslut<Page<article>> commonreslut = new commonreslut<>(200, "查询成功",articlepage);
        return commonreslut;
    }
}
