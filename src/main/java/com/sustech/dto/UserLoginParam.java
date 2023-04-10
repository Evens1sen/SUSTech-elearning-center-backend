package com.sustech.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginParam {
    @NotNull(message = "User id should not be null")
    @ApiModelProperty(value = "uid", required = true)
    private Integer uid;

    @NotNull(message = "Password should not be null")
    @ApiModelProperty(value = "Password", required = true)
    private String password;

    public UserLoginParam(int uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    public UserLoginParam(){

    }
}
