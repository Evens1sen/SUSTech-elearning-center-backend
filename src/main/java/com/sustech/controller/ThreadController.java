package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.entity.Thread;
import com.sustech.service.ThreadService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@RestController
@RequestMapping("//thread")
public class ThreadController {

    @Autowired
    public ThreadService threadService;

    @ApiOperation(value = "获取某用户发布的所有Thread")
    @GetMapping("/")
    public List<Thread> listThreadsByUserID(@PathVariable Integer UserID){
        QueryWrapper<Thread> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", UserID);
        return threadService.list(queryWrapper);
    }
}

