package com.springblog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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

	public UserDto() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}

}
