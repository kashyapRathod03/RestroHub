package com.techOrcas.suchiMitra.category;

public class CategoryDTO {

	public CategoryPojo daoToPojo(Category dao) {
		
		CategoryPojo pojo = new CategoryPojo();
		pojo.setCatId(dao.getCatId());
		pojo.setCatDesc(dao.getCatDesc());
		pojo.setCatName(dao.getCatName());
		pojo.setCreatedDate(dao.getCreatedDate());
		pojo.setDeleted(dao.isDeleted());
		pojo.setFoods(dao.getFoods());
		pojo.setMenu(dao.getMenu());
		pojo.setUpdatedDate(dao.getUpdatedDate());
		return pojo;
	}
	
	public Category pojoToDao(CategoryPojo pojo) {
		
		Category dao = new Category();
		dao.setCatId(pojo.getCatId());
		dao.setCatDesc(pojo.getCatDesc());
		dao.setCatName(pojo.getCatName());
		dao.setCreatedDate(pojo.getCreatedDate());
		dao.setDeleted(pojo.isDeleted());
		dao.setFoods(pojo.getFoods());
		dao.setMenu(pojo.getMenu());
		dao.setUpdatedDate(pojo.getUpdatedDate());
		return dao;
	}
}