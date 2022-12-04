package com.jdbcdemo.demo.entity;

import lombok.Data;

@Data
public abstract class BaseResponse<T> {

    public Integer code;

    public String msg;

    public T data;
}
