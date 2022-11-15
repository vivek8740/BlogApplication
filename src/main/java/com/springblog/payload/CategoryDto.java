package com.springblog.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;

	@NotEmpty
	@Size(max = 100)
	private String categoryTitle;

	@Size(max = 200)
	private String categoryDescription;

}
