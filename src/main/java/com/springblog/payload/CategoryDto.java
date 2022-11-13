package com.springblog.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategoryDto {

	private Integer categoryId;

	@NotEmpty
	@Size(max = 100)
	private String categoryTitle;

	@Size(max = 200)
	private String categoryDescription;

	public CategoryDto() {
		super();
	}

	public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

}
