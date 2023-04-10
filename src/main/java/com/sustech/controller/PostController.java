package com.sustech.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sustech.entity.Post;
import com.sustech.service.PostService;
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
@RequestMapping("//post")
public class PostController {

    @Autowired
    public PostService postService;

    @ApiOperation(value = "获取某thread所有post")
    @GetMapping("/listAllPost/{threadID}")
    public List<Post> listPostByThread(@PathVariable Integer threadID){
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("thread_id", threadID);
        return postService.list(queryWrapper);
    }

}