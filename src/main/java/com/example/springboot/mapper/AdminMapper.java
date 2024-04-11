package com.example.springboot.mapper;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.Request.LoginRequest;
import com.example.springboot.Request.PasswordRequest;
import com.example.springboot.entity.Df;
import com.example.springboot.entity.Fj;
import org.apache.ibatis.annotations.Mapper;
import com.example.springboot.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.List;

@Mapper
public interface AdminMapper {
   Admin getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
   List<Admin> list();
   List<Admin> listByCondition(BaseRequest baseRequest);

    void add(Admin admin);
    void updateById(Admin admin);
    Admin getById(Integer id);
    int updatePassword(PasswordRequest request);
    void save(Admin obj);
    void update1(Admin admin);
    void deleteById(Integer id);
    Admin getByUsername(String username);

    void update0(Admin admin);
}
