package com.example.springboot.Request;

import lombok.Data;

@Data
public class FjPageRequest extends BaseRequest{
    private String room;
    private String type;
    private boolean state;
}
