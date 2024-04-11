package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Dd;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;


public interface IDdService {
    void add(Dd dd);
    void add0(Dd dd);
    PageInfo<Dd> page(BaseRequest baseRequest);
    PageInfo<Dd> page1(BaseRequest baseRequest);
List<Dd> list();
    Dd getById(Integer id);
    void update(Dd obj);
    void deleteById(Integer id);
    Map<String, Object> getCountByTimeRange(String timeRange);

    void updateState(Integer id, String state);
}

