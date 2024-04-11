package com.example.springboot.entity;

import com.example.springboot.Request.DdPageRequest;
import com.example.springboot.Request.PlPageRequest;
import com.example.springboot.Service.IView_plService;
import com.example.springboot.Service.View_ddService;
import com.example.springboot.Service.View_plService;
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
@RequestMapping("/View_pl1")
@Service
public class view_plController {
    @Autowired
    IView_plService view_plService;

@GetMapping("/list")
public Result list() {
List<View_pl> list = view_plService.list();
        return Result.success(list);

}

    @GetMapping("/page")
    public Result page(PlPageRequest plPageRequest) {
        return Result.success(view_plService.page(plPageRequest));
    }






}
