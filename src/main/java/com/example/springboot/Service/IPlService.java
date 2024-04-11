package com.example.springboot.Service;


import com.example.springboot.DTO.PlDTO;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.Request.PlRequest;
import com.example.springboot.entity.Pl;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface IPlService {
    List<Pl> list();
    List<Pl> list1();
    PlDTO pl(PlRequest plRequest);
    void add(Pl obj);
    PageInfo<Pl> page(BaseRequest baseRequest);

    PageInfo<Pl> page1(BaseRequest baseRequest);

    void deleteById(Integer id);

    Pl getById(Integer id);
//    PageInfo<Admin> page(BaseRequest baseRequest);
//    List<Admin> list();
//    void update(Admin obj);
//
//    Admin getById(Integer id);
//    void changePass(PasswordRequest request);
//    void save(Admin obj);
//    void deleteById(Integer id);
}
