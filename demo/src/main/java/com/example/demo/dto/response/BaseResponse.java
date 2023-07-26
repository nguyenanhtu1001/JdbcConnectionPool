package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    private String message;

    private int statusCode;


    private T data;

    public BaseResponse(String message, T data) {
        this.statusCode = 200;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String message) {
        this.statusCode = 200;
        this.message = message;
    }
}