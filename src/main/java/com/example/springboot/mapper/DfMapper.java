package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Df;
import com.example.springboot.entity.Fj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DfMapper extends BaseMapper<Df> {
    void add0(Df df);
    void add(Df df);
    void add1(Df df);
    void add2(Df df);
    List<Df> list();
    List<Df> listByCondition(BaseRequest baseRequest);
    int updateById(Df user);
    Df getById(Integer id);
    void deleteById(Integer id);

    void updateById0(Df df);
    Df getByNo(String paymentStatus);
    void updateById1(Df user);
}
