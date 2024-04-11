package com.example.springboot.mapper;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Count;
import com.example.springboot.entity.Dd;
import com.example.springboot.entity.Df;
import com.example.springboot.entity.Fj;
import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface CountMapper {
 List<Count> list();
 List<Count> list1();
 List<Count> list2();
 List<Count> sum();

    List<Count> listByCondition(BaseRequest baseRequest);
}
