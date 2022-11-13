package com.springblog.service;

import java.util.List;
import com.springblog.payload.CategoryDto;

public interface CategoryService {

	//Create
	CategoryDto createCategory(CategoryDto categoryDto);

	//Update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	//Delete
	void deleteCategory(Integer categoryId);

	//Get All
	List<CategoryDto>getAllCategories();

	//Get By Id
	CategoryDto getCategoryById(Integer CategoryId);

}
