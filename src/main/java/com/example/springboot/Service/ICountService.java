package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Count;
import com.example.springboot.entity.Fj;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICountService {
    List<Count> list();
    List<Count> list1();
    List<Count> list2();
    List<Count> sum();
    PageInfo<Count> page(BaseRequest baseRequest);
}
