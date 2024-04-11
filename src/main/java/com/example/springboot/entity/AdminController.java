package com.example.springboot.entity;
import com.example.springboot.DTO.LoginDTO;
import com.example.springboot.Request.AdminPageRequest;
import com.example.springboot.Request.DfPageRequest;
import com.example.springboot.Request.LoginRequest;
import com.example.springboot.Request.PasswordRequest;
import com.example.springboot.Service.AdminService;
import com.example.springboot.Service.IAdminService;
import com.example.springboot.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//当在使用Spring框架创建Web应用程序时，@ CrossOrigin注释可以帮助您处理跨域请求。如果您的前端和后端代码位于不同的服务器上，则需要通过添加此注释来允许跨域请求。
//        它是一个用于授权远程客户端访问资源的方便注释，并支持跨域请求。 要使用此注释，请将其声明在Spring REST控制器的顶部（如@RestController）。
@RequestMapping("/Admin")
@Service
public class AdminController {
    @Autowired
    IAdminService adminService;
    @GetMapping("/list")
    public List<Admin> list() {
        return adminService.list();
    }
    @GetMapping("/page")
    public Result page(AdminPageRequest adminPageRequest) {
        return Result.success(adminService.page(adminPageRequest));
    }
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        LoginDTO login = adminService.login(loginRequest);
        if (login == null) {
            return Result.error("用户密码错误");
        }
        return Result.success(login);
    }
    @PutMapping("/add")
//    @RequestBody接受前端传递给后端的字符串
    public Result add(@RequestBody Admin admin) {
        adminService.add(admin);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin obj = adminService.getById(id);
        return Result.success(obj);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Admin obj) {
        adminService.update(obj);
        return Result.success();
    }
    @PutMapping("/update1")
    public Result update1(@RequestBody Admin obj){
        adminService.update1(obj);
        return Result.success();
    }
    @PutMapping("/update0")
    public Result update0(@RequestBody Admin obj){
        adminService.update1(obj);
        return Result.success();
    }
    @PutMapping("/password")
    public Result password(@RequestBody PasswordRequest request) {
        adminService.changePass(request);
        return Result.success();
    }
    @PostMapping("/save")
    public Result save(@RequestBody Admin obj) {
        adminService.save(obj);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }



}
