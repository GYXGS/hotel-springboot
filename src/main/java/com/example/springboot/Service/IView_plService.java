package com.example.springboot.Service;


import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.View_dd;
import com.example.springboot.entity.View_pl;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface IView_plService {
//    PlDTO pl(PlRequest plRequest);
//    void add(Pl obj);
List<View_pl> list();
    PageInfo<View_pl> page(BaseRequest baseRequest);
//    void deleteById(Integer id);
//    PageInfo<Admin> page(BaseRequest baseRequest);
//    List<Admin> list();
//    void update(Admin obj);
//
//    Admin getById(Integer id);
//    void changePass(PasswordRequest request);
//    void save(Admin obj);
//    void deleteById(Integer id);
}
