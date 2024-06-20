package com.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mapper.articleMapper;
import com.test.pojo.article;
import com.test.service.articleport;
import org.springframework.stereotype.Service;

@Service
public class articleimpl extends ServiceImpl<articleMapper, article> implements articleport {
}
