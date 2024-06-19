package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.pojo.commonreslut;
import com.test.pojo.product;
import com.test.pojo.shoppingtrolley;
import com.test.service.productport;
import com.test.service.shoppingtrolleyport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 购物车操作

@RestController
@RequestMapping("/com/shoppingtrolley")
public class shoppingtrolleymanagement {
    @Autowired
    private shoppingtrolleyport shoppingtrolleyport;
    @Autowired
    private productport productport;

//    用户商品加入购物车
    @PostMapping("/add")
    public commonreslut<shoppingtrolley> shoppingtrolleyadd(shoppingtrolley shoppingtrolley){
        int code = 201;
        String msg = "加入购物车失败";

        QueryWrapper<shoppingtrolley> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",shoppingtrolley.getUname())
                .eq("pid",shoppingtrolley.getPid())
                .eq("productname",shoppingtrolley.getProductname());

        QueryWrapper<product> wrapper1=new QueryWrapper<>();
        wrapper1.eq("pid",shoppingtrolley.getPid());
        product product=productport.getOne(wrapper1);

        System.out.println(product.getProductprice());
        shoppingtrolley.setProductprice(product.getProductprice());
        System.out.println(shoppingtrolley);
        int i=shoppingtrolleyport.count(wrapper);
        if(i>0){
            int number=shoppingtrolleyport.getOne(wrapper).getNumber();
            shoppingtrolley.setNumber(number+1);
            shoppingtrolley.setId(shoppingtrolleyport.getOne(wrapper).getId());
            shoppingtrolley.setTotalprice(shoppingtrolley.getNumber()*shoppingtrolley.getProductprice());
            boolean bool=shoppingtrolleyport.updateById(shoppingtrolley);
            if(bool){
                msg="加入购物车成功";code=200;
            }
        }else {
            shoppingtrolley.setNumber(1);
            boolean a= shoppingtrolleyport.save(shoppingtrolley);
            if(a){
                msg="加入购物车成功";code=200;
            }
        }

        commonreslut<shoppingtrolley> commonreslut = new commonreslut<>(code, msg);
        return commonreslut;
    }
//    用户删除购物车
    @PostMapping("/delete")
    public commonreslut<shoppingtrolley> shoppingtrolleydelete(shoppingtrolley shoppingtrolley){
        System.out.println(shoppingtrolley);
        int code = 201;
        String msg = "购物车物品删除失败";
        QueryWrapper<shoppingtrolley> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",shoppingtrolley.getUname())
                .eq("productname",shoppingtrolley.getProductname());
        boolean a= shoppingtrolleyport.remove(wrapper);
        if(a){
            msg="购物车物品删除成功";code=200;
        }
        commonreslut<shoppingtrolley> commonreslut = new commonreslut<>(code, msg);
        return commonreslut;
    }
//    用户修改购物车
    @PostMapping("/update")
    public commonreslut<shoppingtrolley> shoppingtrolleyupdate(shoppingtrolley shoppingtrolley){
        System.out.println(shoppingtrolley);
        int code = 201;
        String msg = "购物车修改失败";
        QueryWrapper<shoppingtrolley> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",shoppingtrolley.getUname())
                .eq("productname",shoppingtrolley.getProductname());
        shoppingtrolley shoppingtrolley1= shoppingtrolleyport.getOne(wrapper);
        shoppingtrolley1.setNumber(shoppingtrolley.getNumber());
        shoppingtrolley1.setTotalprice(shoppingtrolley.getNumber()*shoppingtrolley.getProductprice());
        boolean a=shoppingtrolleyport.updateById(shoppingtrolley1);
        if(a){
            msg="购物车修改成功";code=200;
        }
        commonreslut<shoppingtrolley> commonreslut = new commonreslut<>(code, msg);
        return commonreslut;
    }
//    用户打开购物车首页数据
    @PostMapping("/search")
    public commonreslut<List<shoppingtrolley>> shoppingtrolleysearch(shoppingtrolley shoppingtrolley){
        System.out.println(shoppingtrolley);
        int code = 201;
        String msg = "查询购物车失败";
        QueryWrapper<shoppingtrolley> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",shoppingtrolley.getUname());
        List<shoppingtrolley> shoppingtrolleyList=shoppingtrolleyport.list(wrapper);
        int i =shoppingtrolleyport.count(wrapper);
        if(i>=0){
            code=200;
            msg="查询到"+i+"条购物车数据";
        }
        commonreslut<List<shoppingtrolley>> commonreslut = new commonreslut<>(code, msg,shoppingtrolleyList);
        return commonreslut;
    }
//    用户查询购物车商品
    @PostMapping("/searchproduct")
    public commonreslut<List<shoppingtrolley>> shoppingtrolleysearchproduct(shoppingtrolley shoppingtrolley){
        System.out.println(shoppingtrolley);
        int code = 201;
        String msg = "查询购物车失败";
        QueryWrapper<shoppingtrolley> wrapper=new QueryWrapper<>();
        wrapper.eq("uname",shoppingtrolley.getUname());
        wrapper.like("productname",shoppingtrolley.getProductname());
        List<shoppingtrolley> shoppingtrolleyList=shoppingtrolleyport.list(wrapper);
        int i =shoppingtrolleyport.count(wrapper);
        if(i>=0){
            code=200;
            msg="查询到"+i+"条购物车数据";
        }
        commonreslut<List<shoppingtrolley>> commonreslut = new commonreslut<>(code, msg,shoppingtrolleyList);
        return commonreslut;
    }


}
