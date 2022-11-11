package com.springblog.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springblog.entity.User;
import com.springblog.exceptions.ResourceNotFoundException;
import com.springblog.payload.UserDto;
import com.springblog.repositories.UserRepo;
import com.springblog.service.UserService;
import com.springblog.utils.Helper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	@Autowired
	private Helper helper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = helper.userDtoToUser(userDto);
		User savedUser = repo.save(user);
		return helper.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		User updatedUser = repo.save(user);

		return helper.userToUserDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

		return helper.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = repo.findAll();
		
		List<UserDto> userDtos = users.stream().map(u -> helper.userToUserDto(u)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		repo.delete(user);
	}

}
