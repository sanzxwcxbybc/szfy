package com.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mapper.VideoMapper;
import com.test.pojo.video;
import com.test.service.Videoport;
import org.springframework.stereotype.Service;

@Service
public class Video extends ServiceImpl<VideoMapper, video> implements Videoport {
}
