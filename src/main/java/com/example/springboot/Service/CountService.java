package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Count;
import com.example.springboot.entity.Fj;
import com.example.springboot.mapper.CountMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountService implements ICountService {
    @Autowired
    CountMapper countMapper;
    @Override
    public List<Count> list(){return countMapper.list();}
    @Override
    public List<Count> list1(){return countMapper.list1();}
    @Override
    public List<Count> list2(){return countMapper.list2();}
    @Override
    public List<Count> sum(){return countMapper.sum();}
    @Override
    public PageInfo<Count> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Count> counts= countMapper.listByCondition(baseRequest);
        return new PageInfo<>(counts);
    }
}
