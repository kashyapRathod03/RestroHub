package com.restrohub.qrmenu.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restrohub.qrmenu.category.dto.CategoryDTO;
import com.restrohub.qrmenu.category.entity.Category;
import com.restrohub.qrmenu.category.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository  categoryRepository;
	
	@Autowired
	CategoryDTO categoryDto;
	
	@Override
	public CategoryDTO saveCategory(CategoryDTO category) {
		
		Category dao = categoryRepository.save(categoryDto.pojoToDao(category));
		CategoryDTO pojo = categoryDto.daoToPojo(dao);
		return pojo;
	}

	@SuppressWarnings("deprecation")
	@Override
	public CategoryDTO getCategory(long id) {
		
		CategoryDTO pojo = categoryDto.daoToPojo(categoryRepository.getById(id));
		return pojo;
	}
}
