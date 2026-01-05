package com.restrohub.qrmenu.food.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restrohub.qrmenu.food.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("SELECT f FROM Food f WHERE f.foodId IN :ids AND f.isDelete = false")
    List<Food> findByFoodIdInAndIsDeleteFalse(@Param("ids") List<Long> ids);

    @Query("SELECT f FROM Food f JOIN f.categories c WHERE c.categoryId = :categoryId AND f.isDelete = false")
    List<Food> findByCategoryId(@Param("categoryId") Long categoryId);

    Optional<Food> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    Page<Food> findByCategory(String category, Pageable pageable);

    Page<Food> findByIsAvailable(Boolean isAvailable, Pageable pageable);

    @Query("SELECT f FROM Food f WHERE f.isAvailable = true")
    Page<Food> findAllAvailable(Pageable pageable);

    @Query("SELECT f FROM Food f WHERE f.category = :category AND f.isAvailable = true")
    Page<Food> findAvailableByCategory(@Param("category") String category, Pageable pageable);

    @Query("SELECT f FROM Food f WHERE f.price BETWEEN :minPrice AND :maxPrice")
    Page<Food> findByPriceRange(
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            Pageable pageable);

    @Query("SELECT f FROM Food f WHERE f.isVegetarian = true AND f.isAvailable = true")
    Page<Food> findAllVegetarian(Pageable pageable);

    @Query("SELECT f FROM Food f WHERE f.isVeg = true AND f.isAvailable = true")
    Page<Food> findAllVeg(Pageable pageable);

    @Query("SELECT f FROM Food f WHERE f.isGlutenFree = true AND f.isAvailable = true")
    Page<Food> findAllGlutenFree(Pageable pageable);

    @Query("SELECT DISTINCT f.category FROM Food f ORDER BY f.category")
    List<String> findAllCategories();

    @Query("SELECT f FROM Food f WHERE " +
            "(:name IS NULL OR LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:category IS NULL OR f.category = :category) AND " +
            "(:isAvailable IS NULL OR f.isAvailable = :isAvailable) AND " +
            "(:isVegetarian IS NULL OR f.isVegetarian = :isVegetarian) AND " +
            "(:minPrice IS NULL OR f.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR f.price <= :maxPrice)")
    Page<Food> searchFoods(
            @Param("name") String name,
            @Param("category") String category,
            @Param("isAvailable") Boolean isAvailable,
            @Param("isVegetarian") Boolean isVegetarian,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            Pageable pageable);

    @Modifying
    @Query("UPDATE Food f SET f.isAvailable = :available WHERE f.id = :id")
    int updateAvailability(@Param("id") Long id, @Param("available") Boolean available);

}