/**
 * 
 */
package com.springblog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springblog.entity.Category;
import com.springblog.exceptions.ResourceNotFoundException;
import com.springblog.payload.CategoryDto;
import com.springblog.repositories.CategoryRepo;
import com.springblog.service.CategoryService;
import com.springblog.utils.Helper;

/**
 * @author KKVIVEK
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private Helper helper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = helper.categoryDtoToCategory(categoryDto);
		Category savedCategory = categoryRepo.save(category);
		return helper.categoryToCategoryDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", " Id ", categoryId));

		return helper.categoryToCategoryDto(category);

	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", " id ", categoryId));
		categoryRepo.delete(category);

	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categorys = categoryRepo.findAll();

		List<CategoryDto> categoryDtos = categorys.stream().map(u -> helper.categoryToCategoryDto(u))
				.collect(Collectors.toList());

		return categoryDtos;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", " Id ", categoryId));

		return helper.categoryToCategoryDto(category);
	}

}
