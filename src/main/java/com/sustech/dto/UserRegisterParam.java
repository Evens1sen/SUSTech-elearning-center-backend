package com.sustech.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserRegisterParam {
    @NotNull(message = "User id should not be null")
    @Min(value = 10000000, message = "Wrong format")
    @Max(value = 99999999, message = "Wrong format")
    @ApiModelProperty(value = "SID of SUSTech", required = true)
    private Integer userId;

    @ApiModelProperty(value = "Username")
    private String name;

    @NotNull(message = "Password should not be null")
    @ApiModelProperty(value = "Password", required = true)
    private String password;

    @NotNull(message = "Email should not be null")
    @Email(message = "Wrong Format")
    @ApiModelProperty(value = "Email")
    private String email;

}
