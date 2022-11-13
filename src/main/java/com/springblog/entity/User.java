package com.springblog.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	@Size(min=4, message = "Username must be greater than 4 character !!")
	private String name;

	@Email(message = "Email address is not valid!!")
	private String email;

	@NotEmpty
	@Size(min = 4, max = 10 , message ="Password must be  min of 4 char and max 5 char!!")
	private String password;

	@Size(max = 400)
	private String about;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();

}
