package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.pojo.article;
import com.test.pojo.commonreslut;
import com.test.pojo.video;
import com.test.service.Videoport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/video")
public class Videomanage {
    @Autowired
    private Videoport videoport;
//    旅游
    @GetMapping("/search/type1/{p}")
    public commonreslut<Page<video>> searchtype1(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<video> wrapper=new QueryWrapper<>();
        wrapper.eq("videotype",1);
        System.out.println("p="+p);
        Page<video> page =new Page<>(p,1);
        Page<video> videopage=videoport.page(page,wrapper);
        commonreslut<Page<video>> commonreslut = new commonreslut<>(200, "查询成功",videopage);
        return commonreslut;
    }
//    民俗
    @GetMapping("/search/type2/{p}")
    public commonreslut<Page<video>> searchtype2(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<video> wrapper=new QueryWrapper<>();
        wrapper.eq("videotype",2);
        System.out.println("p="+p);
        Page<video> page =new Page<>(p,1);
        Page<video> videopage=videoport.page(page,wrapper);
        commonreslut<Page<video>> commonreslut = new commonreslut<>(200, "查询成功",videopage);
        return commonreslut;
    }
//    革命
    @GetMapping("/search/type4/{p}")
    public commonreslut<Page<video>> searchtype4(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<video> wrapper=new QueryWrapper<>();
        wrapper.eq("videotype",4);
        System.out.println("p="+p);
        Page<video> page =new Page<>(p,1);
        Page<video> videopage=videoport.page(page,wrapper);
        commonreslut<Page<video>> commonreslut = new commonreslut<>(200, "查询成功",videopage);
        return commonreslut;
    }
//    非遗
    @GetMapping("/search/type5/{p}")
    public commonreslut<Page<video>> searchtype5(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<video> wrapper=new QueryWrapper<>();
        wrapper.eq("videotype",5);
        System.out.println("p="+p);
        Page<video> page =new Page<>(p,1);
        Page<video> videopage=videoport.page(page,wrapper);
        commonreslut<Page<video>> commonreslut = new commonreslut<>(200, "查询成功",videopage);
        return commonreslut;
    }
//    硒产品
    @GetMapping("/search/type6/{p}")
    public commonreslut<Page<video>> searchtype6(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<video> wrapper=new QueryWrapper<>();
        wrapper.eq("videotype",6);
        System.out.println("p="+p);
        Page<video> page =new Page<>(p,1);
        Page<video> videopage=videoport.page(page,wrapper);
        commonreslut<Page<video>> commonreslut = new commonreslut<>(200, "查询成功",videopage);
        return commonreslut;
    }
}
