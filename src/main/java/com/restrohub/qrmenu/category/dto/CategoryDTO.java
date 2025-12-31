package com.restrohub.qrmenu.category.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.restrohub.qrmenu.category.entity.Category;
import com.restrohub.qrmenu.food.entity.Food;

public class CategoryDTO {

    private Long categoryId;

    private String name;

    private String description;

    private Boolean isDelete = false;

    private LocalDateTime updatedDate;

    private Set<Food> foods = new HashSet<>();

	private Date createdDate;

    // @ManyToOne(fetch = FetchType.LAZY)
//	private Menu menu;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Set<Food> getFoods() {
		return foods;
	}

	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

//	public Menu getMenu() {
//		return menu;
//	}
//
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}

	public CategoryDTO categoryToPojo(Category category) {

		CategoryDTO pojo = new CategoryDTO();
		pojo.setCatId(category.getCategoryId());
		pojo.setCatName(category.getName());
		pojo.setCatDesc(category.getDescription());
		pojo.setDeleted(category.getIsDelete());
		pojo.setUpdatedDate(category.getUpdatedDate());
		pojo.setFoods(category.getFoods());
		return pojo;
	}
	
	public Category pojoToDao(CategoryDTO pojo) {

		Category category = new Category();
		category.setCategoryId(pojo.getCategoryId());
		category.setCatDesc(pojo.getDescription());
		category.setCatName(pojo.getName());
		category.setCreatedDate(pojo.getCreatedDate());
		category.setDeleted(pojo.getIsDelete());
		category.setFoods(pojo.getFoods());
//		category.setMenu(pojo.getMenu());
		category.setUpdatedDate(pojo.getUpdatedDate());
		return category;
	}
}