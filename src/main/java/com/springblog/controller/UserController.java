package com.springblog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springblog.payload.ResponseApi;
import com.springblog.payload.UserDto;
import com.springblog.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService service;

	// POST -> Create USer
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createdUserDto = service.createUser(userDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}

	// GET -> Fetch All User
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> findAllUsers() {
		List<UserDto> users = service.getAllUsers();
		return ResponseEntity.ok(users);
	}

	// PUT -> Update User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
		UserDto updatedUserDto = service.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUserDto);
	}

	// DELETE
	@DeleteMapping("/{userId}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Integer userId) {
		service.deleteUser(userId);
		return new ResponseEntity(new ResponseApi("Deleted Successfully", true), HttpStatus.OK);
	}
	
	//GET -> get single User
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(service.getUserById(userId));
	}
}
