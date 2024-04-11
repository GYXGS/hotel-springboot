package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Dd {
    private  String order1;
    private String name;
    private String state;
    private String room;
    private String phone;
public int id;
private String type;
private  String value;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate createtime;
    /**
     * 更新时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate latetime;

}
