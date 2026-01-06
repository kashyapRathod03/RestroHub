// src/main/java/com/restrohub/qrmenu/food/service/impl/FoodServiceImpl.java
package com.restrohub.qrmenu.food.service;

import com.restrohub.qrmenu.common.exception.ResourceAlreadyExistsException;
import com.restrohub.qrmenu.common.exception.ResourceNotFoundException;
import com.restrohub.qrmenu.common.generic.GenericMapper;
import com.restrohub.qrmenu.common.generic.PageResponseDTO;
import com.restrohub.qrmenu.food.dto.*;
import com.restrohub.qrmenu.food.entity.Food;
import com.restrohub.qrmenu.food.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.lang.Long;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final GenericMapper<Food,FoodRequestDTO,FoodResponseDTO,FoodUpdateDTO> foodMapper;

    private static final String FOOD_NOT_FOUND_MSG = "Food not found with id: %s";
    private static final String FOOD_EXISTS_MSG = "Food already exists with name: %s";

    @Override
    @Transactional
    @CacheEvict(value = "foods", allEntries = true)
    public FoodResponseDTO createFood(FoodRequestDTO requestDTO) {
        log.info("Creating new food item: {}", requestDTO.getName());

        if (foodRepository.existsByNameIgnoreCase(requestDTO.getName())) {
            log.warn("Attempt to create duplicate food: {}", requestDTO.getName());
            throw new ResourceAlreadyExistsException(
                    String.format(FOOD_EXISTS_MSG, requestDTO.getName()));
        }

        Food food = foodMapper.toEntity(requestDTO);
        Food savedFood = foodRepository.save(food);

        log.info("Successfully created food item with id: {}", savedFood.getFoodId());
        return foodMapper.toResponseDTO(savedFood);
    }

    @Override
    @Cacheable(value = "food", key = "#id")
    public FoodResponseDTO getFoodById(Long id) {
        log.debug("Fetching food by id: {}", id);

        Food food = findFoodByIdOrThrow(id);
        return foodMapper.toResponseDTO(food);
    }

    @Override
    public FoodResponseDTO getFoodByName(String name) {
        log.debug("Fetching food by name: {}", name);

        Food food = foodRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> {
                    log.warn("Food not found with name: {}", name);
                    return new ResourceNotFoundException("Food not found with name: " + name);
                });

        return foodMapper.toResponseDTO(food);
    }

    @Override
    @Cacheable(value = "foods", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public PageResponseDTO<FoodResponseDTO> getAllFoods(Pageable pageable) {
        log.debug("Fetching all foods, page: {}, size: {}",
                pageable.getPageNumber(), pageable.getPageSize());

        Page<Food> foodPage = foodRepository.findAll(pageable);
        return foodMapper.toPageResponseDTO(foodPage);
    }

    @Override
    public PageResponseDTO<FoodResponseDTO> getAvailableFoods(Pageable pageable) {
        log.debug("Fetching available foods, page: {}, size: {}",
                pageable.getPageNumber(), pageable.getPageSize());

        Page<Food> foodPage = foodRepository.findAllAvailable(pageable);
        return foodMapper.toPageResponseDTO(foodPage);
    }

    @Override
    public PageResponseDTO<FoodResponseDTO> getFoodsByCategory(String category, Pageable pageable) {
        log.debug("Fetching foods by category: {}, page: {}",
                category, pageable.getPageNumber());

        Page<Food> foodPage = foodRepository.findByCategory(category, pageable);
        return foodMapper.toPageResponseDTO(foodPage);
    }

    @Override
    public PageResponseDTO<FoodResponseDTO> searchFoods(
            String name,
            String category,
            Boolean isAvailable,
            Boolean isVegetarian,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Pageable pageable) {

        log.debug("Searching foods with filters - name: {}, category: {}, " +
                        "available: {}, vegetarian: {}, priceRange: {}-{}",
                name, category, isAvailable, isVegetarian, minPrice, maxPrice);

        Page<Food> foodPage = foodRepository.searchFoods(
                name, category, isAvailable, isVegetarian, minPrice, maxPrice, pageable);

        return foodMapper.toPageResponseDTO(foodPage);
    }

    @Override
    @Transactional
    @CacheEvict(value = {"food", "foods"}, allEntries = true)
    public FoodResponseDTO updateFood(Long id, FoodUpdateDTO updateDTO) {
        log.info("Updating food with id: {}", id);

        Food existingFood = findFoodByIdOrThrow(id);

        // Check for duplicate name if name is being updated
        if (updateDTO.getName() != null &&
                !updateDTO.getName().equalsIgnoreCase(existingFood.getName()) &&
                foodRepository.existsByNameIgnoreCase(updateDTO.getName())) {

            log.warn("Attempt to update food with duplicate name: {}", updateDTO.getName());
            throw new ResourceAlreadyExistsException(
                    String.format(FOOD_EXISTS_MSG, updateDTO.getName()));
        }

        foodMapper.updateEntityFromDTO(updateDTO, existingFood);
        Food updatedFood = foodRepository.save(existingFood);

        log.info("Successfully updated food with id: {}", id);
        return foodMapper.toResponseDTO(updatedFood);
    }

    @Override
    @Transactional
    @CacheEvict(value = {"food", "foods"}, allEntries = true)
    public FoodResponseDTO updateAvailability(Long id, Boolean available) {
        log.info("Updating availability for food id: {} to: {}", id, available);

        Food food = findFoodByIdOrThrow(id);
        food.setIsAvailable(available);
        Food updatedFood = foodRepository.save(food);

        log.info("Successfully updated availability for food id: {}", id);
        return foodMapper.toResponseDTO(updatedFood);
    }

    @Override
    @Transactional
    @CacheEvict(value = {"food", "foods"}, allEntries = true)
    public void deleteFood(Long id) {
        log.info("Deleting food with id: {}", id);

        if (!foodRepository.existsById(id)) {
            log.warn("Attempt to delete non-existent food with id: {}", id);
            throw new ResourceNotFoundException(String.format(FOOD_NOT_FOUND_MSG, id));
        }

        foodRepository.deleteById(id);
        log.info("Successfully deleted food with id: {}", id);
    }

    @Override
    @Cacheable(value = "categories")
    public List<String> getAllCategories() {
        log.debug("Fetching all food categories");
        return foodRepository.findAllCategories();
    }

    @Override
    public boolean existsById(Long id) {
        return foodRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return foodRepository.existsByNameIgnoreCase(name);
    }

    private Food findFoodByIdOrThrow(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Food not found with id: {}", id);
                    return new ResourceNotFoundException(String.format(FOOD_NOT_FOUND_MSG, id));
                });
    }
}