package com.techOrcas.suchiMitra.foodItem;

import java.sql.Date;
import java.util.List;

import com.techOrcas.suchiMitra.category.Category;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_food_master")
public class FoodMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private long foodId;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(name = "food_desc")
    private String foodDesc;

    @Column(name = "price")
    private int price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "is_veg")
    private boolean isVeg;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToMany
    @JoinTable(
        name = "t_rel_food_cat",
        joinColumns = @JoinColumn(name = "food_id"),
        inverseJoinColumns = @JoinColumn(name = "cat_id")
    )
    private List<Category> categories;

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodDesc() {
		return foodDesc;
	}

	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}

