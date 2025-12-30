package com.techOrcas.suchiMitra.category;

import java.sql.Date;
import java.util.List;

import com.techOrcas.suchiMitra.foodItem.FoodMaster;
import com.techOrcas.suchiMitra.menu.Menu;

public class CategoryPojo {

	private long catId;

    private String catName;

    private String catDesc;

    private boolean isDeleted;

    private Date updatedDate;

    private Date createdDate;

    private List<FoodMaster> foods;

    private Menu menu;

	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<FoodMaster> getFoods() {
		return foods;
	}

	public void setFoods(List<FoodMaster> foods) {
		this.foods = foods;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
