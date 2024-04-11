package com.example.springboot.mapper;

import com.example.springboot.Request.BaseRequest;

import com.example.springboot.entity.View_dd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface View_ddMapper {




    List<View_dd> list();

    List<View_dd> listByCondition1(BaseRequest baseRequest);
}
