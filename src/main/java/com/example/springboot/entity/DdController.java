package com.example.springboot.entity;

import com.alipay.api.domain.Goods;
import com.example.springboot.Request.DdPageRequest;
import com.example.springboot.Service.DdService;
import com.example.springboot.Service.IDdService;
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
import java.util.Map;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Dd")
@Service

public class DdController {


    @Autowired
    IDdService ddService;
    @PutMapping("/add")
//    @RequestBody接受前端传递给后端的字符串
    public Result add(@RequestBody Dd obj) {
        ddService.add(obj);
        return Result.success();
    }
    @PutMapping("/add0")
    public Result add0( Dd dd){
        ddService.add0(dd);
        return  Result.success();
    }
@GetMapping("/list")
public Result list() {
List<Dd> list = ddService.list();
        return Result.success(list);
//    public List<Dd> list(){
//        return ddService.list();
}
    @GetMapping("/page")
    public Result page(DdPageRequest ddPageRequest) {
        return Result.success(ddService.page(ddPageRequest));
    }
    @GetMapping("/page1")
    public Result page1(DdPageRequest ddPageRequest) {
        return Result.success(ddService.page1(ddPageRequest));
    }
    @PutMapping("/update")
    public Result update(@RequestBody Dd obj) {
        ddService.update(obj);
        return Result.success();
    }
    @PutMapping("/updateState")
    public Result updateState(@RequestBody Map<String, Object> params) {
        Integer id = (Integer) params.get("id");
        String state = (String) params.get("state");
        // 调用服务层的方法来更新数据库中的数据
        // 你需要在你的服务层中实现这个方法
        ddService.updateState(id, state);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Dd obj = ddService.getById(id);
        return Result.success(obj);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        ddService.deleteById(id);
        return Result.success();
    }

//这段代码是一个基于spring boot框架编写的java方法，通过 @getmapping("/page") 来声明一个get请求路径并与该方法相对应。当浏览器或其他客户端通过http get请求访问该地址时，将触发执行这个方法。
//    在这个方法中，使用了 clainservice 对象来调用业务逻辑访问数据库，并传入 clainpagerequest 参数对象。其中，clainpagerequest 对象是通过请求参数自动绑定而来的，在方法内部也可以对其进行进一步处理和解析。
//    最后，使用 result.success() 方法返回一个成功的结果对象，其中包含了从 clainservice.page 得到分页查询结果，即学生信息以及分页信息等内容。通常，这种方式会将查询结果序列化为json字符串进行响应返回，让客户端可以方便地对其进行处理和视图渲染。

    @GetMapping("/lineCharts/{timeRange}")
    public Result lineCharts(@PathVariable String timeRange) {
        return Result.success(ddService.getCountByTimeRange(timeRange));
    }



}
