package com.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mapper.OrderformMapper;
import com.test.pojo.orderform;
import com.test.service.orderformport;
import org.springframework.stereotype.Service;

@Service
public class orderformimpl extends ServiceImpl<OrderformMapper, orderform> implements orderformport {
}
