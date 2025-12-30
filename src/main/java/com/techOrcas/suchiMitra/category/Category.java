package com.techOrcas.suchiMitra.category;

import java.sql.Date;
import java.util.List;

import com.techOrcas.suchiMitra.foodItem.FoodMaster;
import com.techOrcas.suchiMitra.menu.Menu;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_category_master")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private long catId;

    @Column(name = "cat_name", nullable = false)
    private String catName;

    @Column(name = "cat_desc")
    private String catDesc;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToMany(mappedBy = "categories")
    private List<FoodMaster> foods;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
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
