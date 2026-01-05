// src/main/java/com/restrohub/qrmenu/food/service/FoodService.java
package com.restrohub.qrmenu.food.service;

import com.restrohub.qrmenu.food.dto.*;
import org.springframework.data.domain.Pageable;

import java.lang.Long;
import java.math.BigDecimal;
import java.util.List;

public interface FoodService {

    FoodResponseDTO createFood(FoodRequestDTO requestDTO);

    FoodResponseDTO getFoodById(Long id);

    FoodResponseDTO getFoodByName(String name);

    FoodPageResponseDTO getAllFoods(Pageable pageable);

    FoodPageResponseDTO getAvailableFoods(Pageable pageable);

    FoodPageResponseDTO getFoodsByCategory(String category, Pageable pageable);

    FoodPageResponseDTO searchFoods(
            String name,
            String category,
            Boolean isAvailable,
            Boolean isVegetarian,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Pageable pageable);

    FoodResponseDTO updateFood(Long id, FoodUpdateDTO updateDTO);

    FoodResponseDTO updateAvailability(Long id, Boolean isAvailable);

    void deleteFood(Long id);

    List<String> getAllCategories();

    boolean existsById(Long id);

    boolean existsByName(String name);
}