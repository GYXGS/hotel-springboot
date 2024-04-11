package com.example.springboot.Service;

import com.example.springboot.DTO.LoginDTO;
import com.example.springboot.Request.BaseRequest;
import com.example.springboot.Request.LoginRequest;
import com.example.springboot.Request.PasswordRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Fj;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAdminService {
    LoginDTO login(LoginRequest request);
    PageInfo<Admin> page(BaseRequest baseRequest);
    List<Admin> list();

    void update(Admin obj);
    Admin getById(Integer id);

    void update0(Admin obj);

    void changePass(PasswordRequest request);
    void save(Admin obj);
    void deleteById(Integer id);
    void update1(Admin obj);

    void add(Admin admin);
}
