package com.springblog.controller;

import com.springblog.payload.CategoryDto;
import com.springblog.payload.ResponseApi;
import com.springblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@ComponentScan(basePackages = "com.springbb")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// POST -> Create Category
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto createdCategoryDto = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createdCategoryDto, HttpStatus.CREATED);
	}

	// PUT -> Update Category
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
			@PathVariable Integer categoryId) {
		CategoryDto updatedCategoryDto = categoryService.updateCategory(categoryDto, categoryId);
		return ResponseEntity.ok(updatedCategoryDto);
	}

	// GET -> Fetch All Category
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> findAllCategorys() {
		List<CategoryDto> categorys = categoryService.getAllCategories();
		return ResponseEntity.ok(categorys);
	}

	// GET -> get single Category
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> findSingleCategory(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
	}

	// DELETE
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ResponseApi> deleteCategory(@PathVariable Integer categoryId) {
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ResponseApi>(new ResponseApi("Deleted Successfully", true), HttpStatus.OK);
	}

}
