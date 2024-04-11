package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Df {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date payTime;
    private String orderId;
    private String alipayNo;

    public  String name;
    public String phone;
    public String type;

    public String card;
    public String state;
    public  Integer id;
    public String room;
    public String price;
    public String paymentStatus;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate submitTime;

    /**
     * 更新时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    private LocalDate updatetime;

    private LocalDate begintime;

    private LocalDate latetime;
}
