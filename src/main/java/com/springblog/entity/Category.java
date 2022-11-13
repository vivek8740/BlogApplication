package com.springblog.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;

	@Column(name = "title", nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String categoryTitle;

	@Column(name = "description")
	@Size(max = 200)
	private String categoryDescription;

	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
}
