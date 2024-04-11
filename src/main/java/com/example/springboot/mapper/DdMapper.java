package com.example.springboot.mapper;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Dd;
import com.example.springboot.mapper.po.ddCountpo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DdMapper {

    void add(Dd dd);
void add0(Dd dd);

    List<Dd> list();
    List<Dd> listByCondition(BaseRequest baseRequest);
    List<Dd> listByCondition1(BaseRequest baseRequest);
    void updateById(Dd user);
    Dd getById(int id);
    void deleteById(int id);
    List<ddCountpo> getCountByTimeRange(@Param("timeRange") String timeRange, @Param("type") int type);  // 1 dd 2 df

    void updateState(Integer id, String state);


}


