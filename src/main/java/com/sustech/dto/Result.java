package com.sustech.dto;

import lombok.Data;

@Data
public class Result<T> {

    /**
     * The status code in ResultCode
     */
    private int code;
    /**
     * The message in ResultCode
     */
    private String msg;
    /**
     * The detailed data in response, null for unsuccessful response
     */
    private T data;

    public Result(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public Result(ResultCode code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

}
