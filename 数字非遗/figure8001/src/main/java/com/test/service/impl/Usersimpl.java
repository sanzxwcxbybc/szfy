package com.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mapper.UserMapper;
import com.test.pojo.users;
import com.test.service.usersport;
import org.springframework.stereotype.Service;

@Service
public class Usersimpl extends ServiceImpl<UserMapper, users> implements usersport {
}
