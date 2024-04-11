package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Dd;
import com.example.springboot.entity.Df;
import com.example.springboot.entity.Fj;
import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface FjMapper extends BaseMapper<Fj> {
    void add(Fj fj);
    List<Fj> list();
    List<Fj> listByCondition(BaseRequest baseRequest);
    List<Fj> listByCondition1(BaseRequest baseRequest);
    List<Fj> listByCondition2(BaseRequest baseRequest);
    int updateById(Fj user);
    void updateByState(Fj user);
    void updateByState1(Fj user);
    Fj getById(Integer id);
    void deleteById(Integer id);
    Fj getByNo(String room);

}
