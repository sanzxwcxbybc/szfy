package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.pojo.article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface articleMapper extends BaseMapper<article> {
}
