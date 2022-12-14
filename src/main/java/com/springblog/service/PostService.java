package com.springblog.service;

import com.springblog.payload.PostDto;

import java.util.List;

public interface PostService {

    //Create post
    PostDto createPost(PostDto postDto, Integer userId, Integer CategoryId);

    //Update post
    PostDto updatePost(PostDto postDto, Integer postId);

    //Delete Post
    void deletePost(Integer postId);

    //getAll post
    List<PostDto> getAllPost();

    //get post by Id
    PostDto getPostById(Integer postId);

    //get post by category
    List<PostDto> getPostByCategory(Integer categoryId);

    //getPost as per user
    List<PostDto> getPostByUser(Integer userId);

    //fetch posts on page basis
    List<PostDto> getPostsOnPageBasis(Integer pageSize,Integer pageNo);



}
