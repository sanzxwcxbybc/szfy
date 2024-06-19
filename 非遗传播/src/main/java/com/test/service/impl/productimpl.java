package com.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mapper.ProductMapper;
import com.test.pojo.product;
import com.test.service.productport;
import org.springframework.stereotype.Service;

@Service
public class productimpl extends ServiceImpl<ProductMapper, product> implements productport {
}
