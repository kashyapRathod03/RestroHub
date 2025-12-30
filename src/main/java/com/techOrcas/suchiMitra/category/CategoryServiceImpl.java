package com.techOrcas.suchiMitra.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository  categoryRepository;
	
	@Autowired
	CategoryDTO categoryDto;
	
	@Override
	public CategoryPojo saveCategory(CategoryPojo category) {
		
		Category dao = categoryRepository.save(categoryDto.pojoToDao(category));
		CategoryPojo pojo = categoryDto.daoToPojo(dao);
		return pojo;
	}

	@SuppressWarnings("deprecation")
	@Override
	public CategoryPojo getCategory(long id) {
		
		CategoryPojo pojo = categoryDto.daoToPojo(categoryRepository.getById(id));
		return pojo;
	}
}
