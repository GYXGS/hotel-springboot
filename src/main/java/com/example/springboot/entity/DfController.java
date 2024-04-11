package com.example.springboot.entity;

import com.example.springboot.Request.DfPageRequest;
import com.example.springboot.Service.DfService;
import com.example.springboot.Service.IDfService;
import com.example.springboot.common.Result;
import com.example.springboot.mapper.DfMapper;
import com.example.springboot.mapper.FjMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Df")
@Service
@MapperScan("com.example.springboot.mapper")

public class DfController {
    @Resource
    private DfMapper dfMapper;

    @Resource
    private FjMapper fjMapper;
    @Autowired
    IDfService dfService;
    @PutMapping("/add0")
    public Result add0(@RequestBody Df df){
        dfService.add0(df);
        return Result.success();
    }
    @PutMapping("/add")
//    @RequestBody接受前端传递给后端的字符串
    public Result add(@RequestBody Df df) {
        dfService.add(df);
        return Result.success();
    }
    @PutMapping("/add1")
//    @RequestBody接受前端传递给后端的字符串
    public Result add1(@RequestBody Df df) {
        dfService.add1(df);
        return Result.success();
    }
    @PutMapping("/add2")
//    @RequestBody接受前端传递给后端的字符串
    public Result add2(@RequestBody Df df) {
        dfService.add2(df);
        return Result.success();
    }
@GetMapping("/list")
public Result list() {
List<Df> list = dfService.list();
        return Result.success(list);
//    public List<Df> list(){
//        return dfService.list();
}
    @GetMapping("/page")
    public Result page(DfPageRequest dfPageRequest) {
        return Result.success(dfService.page(dfPageRequest));
    }
    @PutMapping("/update")
    public Result update(@RequestBody Df obj) {
        dfService.update(obj);
        return Result.success();
    }
    @PutMapping("/update1")
    public Result update1(@RequestBody Df obj) {
        dfService.update1(obj);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Df obj = dfService.getById(id);
        return Result.success(obj);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        dfService.deleteById(id);
        return Result.success();
    }
    @PutMapping("/updateStatus")
    public Result updateStatus(@RequestBody Df obj) {
        dfService.updateStatus(obj);
        return Result.success();
    }

//这段代码是一个基于spring boot框架编写的java方法，通过 @getmapping("/page") 来声明一个get请求路径并与该方法相对应。当浏览器或其他客户端通过http get请求访问该地址时，将触发执行这个方法。
//    在这个方法中，使用了 clainservice 对象来调用业务逻辑访问数据库，并传入 clainpagerequest 参数对象。其中，clainpagerequest 对象是通过请求参数自动绑定而来的，在方法内部也可以对其进行进一步处理和解析。
//    最后，使用 result.success() 方法返回一个成功的结果对象，其中包含了从 clainservice.page 得到分页查询结果，即学生信息以及分页信息等内容。通常，这种方式会将查询结果序列化为json字符串进行响应返回，让客户端可以方便地对其进行处理和视图渲染。

}
