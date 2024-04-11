package com.example.springboot.mapper;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.Request.PlRequest;
import com.example.springboot.entity.Pl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlMapper {
    List<Pl> list();
    Pl getByOrder(PlRequest plRequest);
    void add(Pl obj);
    List<Pl> listByCondition(BaseRequest baseRequest);
    List<Pl> listByCondition1(BaseRequest baseRequest);
    void deleteById(Integer id);
    Pl getById(Integer id);

    List<Pl> list1();
}
