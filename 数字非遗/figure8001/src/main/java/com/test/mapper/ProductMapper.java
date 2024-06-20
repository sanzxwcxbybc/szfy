package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.pojo.product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<product> {

}

