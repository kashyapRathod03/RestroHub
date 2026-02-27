package com.restroly.qrmenu.category.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.restroly.qrmenu.category.entity.Category;
import com.restroly.qrmenu.food.entity.Food;

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

	public CategoryDTO categoryToDto(Category category) {

		CategoryDTO pojo = new CategoryDTO();
		pojo.setCategoryId(category.getCategoryId());
		pojo.setName(category.getName());
		pojo.setDescription(category.getDescription());
		pojo.setIsDelete(category.getIsDelete());
		pojo.setUpdatedDate(category.getUpdatedDate());
		pojo.setFoods(category.getFoods());
		return pojo;
	}
	
	public Category dtoToCategory(CategoryDTO pojo) {

		Category category = new Category();
		category.setCategoryId(pojo.getCategoryId());
		category.setDescription(pojo.getDescription());
		category.setName(pojo.getName());
//		category.setCreatedDate(pojo.getCreatedDate());
		category.setIsDelete(pojo.getIsDelete());
		category.setFoods(pojo.getFoods());
//		category.setMenu(pojo.getMenu());
		category.setUpdatedDate(pojo.getUpdatedDate());
		return category;
	}
}