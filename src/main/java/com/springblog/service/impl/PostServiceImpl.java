package com.springblog.service.impl;

import com.springblog.entity.Category;
import com.springblog.entity.Post;
import com.springblog.entity.User;
import com.springblog.exceptions.ResourceNotFoundException;
import com.springblog.payload.PostDto;
import com.springblog.repositories.CategoryRepo;
import com.springblog.repositories.PostRepo;
import com.springblog.repositories.UserRepo;
import com.springblog.service.PostService;
import com.springblog.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private Helper helper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        //Fetch User
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        //Fetch Category
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", " Id ", categoryId));

        Post newPost = helper.PostDtoToPost(postDto);
        newPost.setImageName("default.png");
        newPost.setPostDate(new Date());
        newPost.setUser(user);
        newPost.setCategory(category);
        Post addedPost =  postRepo.save(newPost);

        return helper.PostToPostDto(addedPost);
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPost() {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByCategory() {
        return null;
    }

    @Override
    public List<PostDto> getPostByUser() {
        return null;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return null;
    }
}
