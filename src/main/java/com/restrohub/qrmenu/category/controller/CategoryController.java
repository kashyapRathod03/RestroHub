package com.restrohub.qrmenu.category.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restrohub.qrmenu.category.dto.CategoryDTO;
import com.restrohub.qrmenu.category.service.CategoryService;

@RequestMapping("/public/category")
@RestController
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getCategory")
	public ResponseEntity<CategoryDTO> getCategory(@RequestParam long id) {
		try {
			CategoryDTO category = categoryService.getCategory(id);
			return ResponseEntity.ok(category);
		} catch (Exception e) {
			LOGGER.error("Error fetching category with id: " + id, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/addCategory")
	public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO category) {
		try {
			CategoryDTO pojo = categoryService.saveCategory(category);
			return ResponseEntity.ok(pojo);
		} catch (Exception e) {
			LOGGER.error("Error saving category: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
