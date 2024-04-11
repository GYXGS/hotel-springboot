package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class Pl {
    private static final long serialVersionUID = 1L;
    public Integer id;
    public String mean;
    public String order1;
    public String type;
    public String photos;
    private List<String> categories;
    /**
     * 分类
     */
    private String category;
    public boolean mean_status;
}
