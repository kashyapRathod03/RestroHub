package com.restroly.qrmenu.category.service;

import com.restroly.qrmenu.category.dto.CategoryDTO;

public interface CategoryService {

	public CategoryDTO saveCategory(CategoryDTO category);
	
	public CategoryDTO getCategory(long id);
}
