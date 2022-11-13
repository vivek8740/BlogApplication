package com.springblog.utils;

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
		/*
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
		*/
	}
	
	//Helper Method to convert User to DTO
	public UserDto userToUserDto(User user) {
		return mapper.map(user, UserDto.class);

		/*
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;

		*/
	}

	public CategoryDto categoryToCategoryDto(Category savedCategory) {
		return mapper.map(savedCategory, CategoryDto.class);
	}

	public Category categoryDtoToCategory(CategoryDto categoryDto) {
		return mapper.map(categoryDto, Category.class);
	}

}
