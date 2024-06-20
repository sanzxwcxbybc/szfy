package com.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mapper.LogMapper;
import com.test.pojo.log;
import com.test.service.logport;
import org.springframework.stereotype.Service;


@Service
public class Logimpl extends ServiceImpl<LogMapper, log> implements logport {
}
