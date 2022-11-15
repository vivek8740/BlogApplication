package com.springblog.controller;

import com.springblog.payload.PostDto;
import com.springblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    PostService postService;
    //Create post
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){
        PostDto newPostDto = postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(newPostDto, HttpStatus.CREATED);
    }
}
