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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId",postId));
        post.setPostTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatePost = postRepo.save(post);

        return helper.PostToPostDto(updatePost);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId",postId));
        postRepo.deleteById(post.getPostId());
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepo.findAll();
        List<PostDto> postDtoList = posts.stream().map(p -> helper.PostToPostDto(p)).toList();
        return postDtoList;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post","postId",postId));
        return helper.PostToPostDto(post);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
        List<Post> posts = this.postRepo.findByCategory(category);
        List<PostDto> postDtoList = posts.stream().map(e -> helper.PostToPostDto(e)).toList();
        return postDtoList;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));
        List<Post> post = this.postRepo.findByUser(user);
        return post.stream().map(e-> helper.PostToPostDto(e)).toList();
    }

    @Override
    public List<PostDto> getPostsOnPageBasis(Integer pageSize, Integer pageNo) {

        Pageable p = PageRequest.of(pageNo, pageSize);
        Page<Post> pagePost = postRepo.findAll(p);
        List<Post> allPosts = pagePost.getContent();

        return allPosts.stream().map( post -> helper.PostToPostDto(post)).toList();
    }

}
