package com.restrohub.qrmenu.category.service;

import com.restrohub.qrmenu.category.dto.CategoryDTO;

public interface CategoryService {

	public CategoryDTO saveCategory(CategoryDTO category);
	
	public CategoryDTO getCategory(long id);
}
