package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.View_dd;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface IView_ddService {
//    void add(Dd dd);
//    PageInfo<Dd> page(BaseRequest baseRequest);
    PageInfo<View_dd> page1(BaseRequest baseRequest);
List<View_dd> list();
//    Dd getById(Integer id);
//    void update(Dd obj);
//    void deleteById(Integer id);
}


