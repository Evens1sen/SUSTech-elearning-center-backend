package com.sustech.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Api(tags = "UserController")
@RestController
@RequestMapping("//user")
public class UserController {

    @ApiOperation(value = "demo")
    @GetMapping("/demo")
    public String demo() {
        return "qx";
    }

}

