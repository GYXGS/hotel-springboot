package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Dd;
import com.example.springboot.entity.Df;
import com.example.springboot.entity.Fj;
import com.example.springboot.mapper.DfMapper;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface IDfService {
    void add0(Df df);

    void add(Df df);
    void add1(Df df);
    void add2(Df df);
    PageInfo<Df> page(BaseRequest baseRequest);
List<Df> list();
    Df getById(Integer id);
    void update(Df obj);
    void deleteById(Integer id);
    void updateStatus(Df obj);

    void update1(Df obj);
}
