package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;

import com.example.springboot.Request.FjPageRequest;
import com.example.springboot.entity.Dd;
import com.example.springboot.entity.Fj;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IFjService {
    void add(Fj fj);
    PageInfo<Fj> page(BaseRequest baseRequest);
    PageInfo<Fj> page1(BaseRequest baseRequest);
    PageInfo<Fj> page2(BaseRequest baseRequest);
    List<Fj> list();
    Fj getById(Integer id);
    void update(Fj obj);
    void updateState(Fj obj);
    void updateState1(Fj obj);
    void deleteById(Integer id);



}
