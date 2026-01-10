package com.restrohub.qrmenu.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restrohub.qrmenu.restaurant.entity.Restaurant;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);
}
