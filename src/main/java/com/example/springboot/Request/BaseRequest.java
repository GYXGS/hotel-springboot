package com.example.springboot.Request;

import lombok.Data;
@Data
public class BaseRequest {
        private Integer pageNum = 1;
        private Integer pageSize = 10;
}
