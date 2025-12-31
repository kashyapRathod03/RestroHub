package com.restrohub.qrmenu.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restrohub.qrmenu.food.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByIsDeleteFalse();

    List<Food> findByIsVegTrue();
    
    @Query("SELECT f FROM Food f WHERE f.foodId IN :ids AND f.isDelete = false")
    List<Food> findByFoodIdInAndIsDeleteFalse(@Param("ids") List<Long> ids);

    @Query("SELECT f FROM Food f JOIN f.categories c WHERE c.categoryId = :categoryId AND f.isDelete = false")
    List<Food> findByCategoryId(@Param("categoryId") Long categoryId);
}