package com.example.springboot.Request;

import lombok.Data;

@Data
public class CountPageRequest extends BaseRequest {
    private String count_dan;
    private String count_suan;
}
