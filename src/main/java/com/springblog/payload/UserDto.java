package com.springblog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	
	private int id;

	@NotEmpty
	@Size(min=4, message = "Username must be greater than 4 character !!")
	private String name;

	@Email(message = "Email address is not valid!!")
	private String email;

	@NotEmpty
	@Size(min = 4, max = 10 , message ="Password must be  min of 4 char and max 5 char!!")
	private String password;
	private String about;

}
