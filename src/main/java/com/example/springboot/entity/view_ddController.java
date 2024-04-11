package com.example.springboot.entity;

import com.example.springboot.Request.DdPageRequest;
import com.example.springboot.Service.DdService;
import com.example.springboot.Service.IView_ddService;
import com.example.springboot.Service.View_ddService;
import com.example.springboot.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/View_dd")
@Service
public class view_ddController {
    @Autowired
    IView_ddService view_ddService;
//    @PutMapping("/add")
////    @RequestBody接受前端传递给后端的字符串
//    public Result add(@RequestBody View_dd obj) {
//        view_ddService.add(obj);
//        return Result.success();
//    }
@GetMapping("/list")
public Result list() {
List<View_dd> list = view_ddService.list();
        return Result.success(list);
//    public List<View_dd> list(){
//        return view_ddService.list();
}
//    @GetMapping("/page")
//    public Result page(DdPageRequest ddPageRequest) {
//        return Result.success(view_ddService.page(ddPageRequest));
//    }
    @GetMapping("/page1")
    public Result page1(DdPageRequest ddPageRequest) {
        return Result.success(view_ddService.page1(ddPageRequest));
    }
//    @PutMapping("/update")
//    public Result update(@RequestBody View_dd obj) {
//        view_ddService.update(obj);
//        return Result.success();
//    }
//    @GetMapping("/{id}")
//    public Result getById(@PathVariable Integer id) {
//        View_dd obj = view_ddService.getById(id);
//        return Result.success(obj);
//    }
//    @DeleteMapping("/delete/{id}")
//    public Result delete(@PathVariable Integer id) {
//        view_ddService.deleteById(id);
//        return Result.success();
//    }

//这段代码是一个基于spring boot框架编写的java方法，通过 @getmapping("/page") 来声明一个get请求路径并与该方法相对应。当浏览器或其他客户端通过http get请求访问该地址时，将触发执行这个方法。
//    在这个方法中，使用了 clainservice 对象来调用业务逻辑访问数据库，并传入 clainpagerequest 参数对象。其中，clainpagerequest 对象是通过请求参数自动绑定而来的，在方法内部也可以对其进行进一步处理和解析。
//    最后，使用 result.success() 方法返回一个成功的结果对象，其中包含了从 clainservice.page 得到分页查询结果，即学生信息以及分页信息等内容。通常，这种方式会将查询结果序列化为json字符串进行响应返回，让客户端可以方便地对其进行处理和视图渲染。





}
