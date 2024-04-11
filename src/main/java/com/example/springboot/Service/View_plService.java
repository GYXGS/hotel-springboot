package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.View_dd;
import com.example.springboot.entity.View_pl;
import com.example.springboot.mapper.View_plMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class View_plService implements IView_plService {
    @Autowired
    View_plMapper view_plMapper;
    public List<View_pl> list(){return view_plMapper.list();}

    @Override
    public PageInfo<View_pl> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<View_pl> Pls = view_plMapper.listByCondition(baseRequest);
        return new PageInfo<>(Pls);
    }

}
