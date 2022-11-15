package com.springblog.utils;

import com.springblog.entity.Post;
import com.springblog.payload.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springblog.entity.Category;
import com.springblog.entity.User;
import com.springblog.payload.CategoryDto;
import com.springblog.payload.UserDto;

@Service
public class Helper {
	
	
	@Autowired
	private ModelMapper mapper;

	//Helper Method to convert DTO to User
	public User userDtoToUser(UserDto userDto) {
		return mapper.map(userDto, User.class);
	}
	
	//Helper Method to convert User to DTO
	public UserDto userToUserDto(User user) {
		return mapper.map(user, UserDto.class);
	}

	public CategoryDto categoryToCategoryDto(Category savedCategory) {
		return mapper.map(savedCategory, CategoryDto.class);
	}

	public Category categoryDtoToCategory(CategoryDto categoryDto) {
		return mapper.map(categoryDto, Category.class);
	}

	public Post PostDtoToPost(PostDto postDto){
		return mapper.map(postDto, Post.class);
	}

	public PostDto PostToPostDto(Post post){
		return mapper.map(post, PostDto.class);
	}
}
