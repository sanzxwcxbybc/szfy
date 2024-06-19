package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.pojo.commonreslut;
import com.test.pojo.product;
import com.test.service.productport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/com/rankinglist")
public class rankinglist {
    @Autowired
    private productport productport;
//  商品销售量排行
    @GetMapping("/king/{p}")
    public commonreslut<Page<product>> rankinglist(@PathVariable("p") int p){
        String msg = "查询错误";
        int code = 201;
        QueryWrapper<product> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("salenumber");
        System.out.println("p="+p);
        Page<product> page =new Page<>(p,5);
        Page<product> productspage=productport.page(page,wrapper);
        commonreslut<Page<product>> commonreslut = new commonreslut<>(200, "查询成功",productspage);
        return commonreslut;
    }

}