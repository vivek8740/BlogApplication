package com.springblog.service;

import com.springblog.entity.Post;
import com.springblog.payload.PostDto;

import java.util.List;

public interface PostService {

    //Create post
    PostDto createPost(PostDto postDto, Integer userId, Integer CategoryId);

    //Update post
    PostDto updatePost(PostDto postDto);

    //Delete Post
    void deletePost(Integer postId);

    //getAll post
    List<PostDto> getAllPost();

    //get post by Id
    PostDto getPostById(Integer postId);

    //get post by category
    List<PostDto> getPostByCategory();

    //getPost as per user
    List<PostDto> getPostByUser();

    //Search post
    List<PostDto> searchPost(String keyword);

}