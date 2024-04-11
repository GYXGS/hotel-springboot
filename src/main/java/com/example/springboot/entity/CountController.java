package com.example.springboot.entity;

import com.example.springboot.Request.CountPageRequest;

import com.example.springboot.Service.ICountService;
import com.example.springboot.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Count")
@Service
public class CountController {
    @Autowired
    ICountService countService;
    @GetMapping("/list")
    public Result list(){
        List<Count> count = countService.list();
        return  Result.success(count);
    }
    @GetMapping("/list1")
    public Result list1(){
        List<Count> count1 = countService.list1();
        return  Result.success(count1);
    }
    @GetMapping("/list2")
    public Result list2(){
        List<Count> count2 = countService.list2();
        return  Result.success(count2);
    }
    @GetMapping("/sum")
    public Result sum(){
        List<Count> sum = countService.sum();
        return  Result.success(sum);
    }
    @GetMapping("/page")
    public Result page(CountPageRequest countPageRequest) {
        return Result.success(countService.page(countPageRequest));
    }
}
