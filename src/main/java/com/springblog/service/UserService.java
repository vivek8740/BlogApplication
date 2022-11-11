package com.springblog.service;

import java.util.List;
import com.springblog.payload.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto userDto, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto>getAllUsers();
	
	void deleteUser(Integer userId);

}
