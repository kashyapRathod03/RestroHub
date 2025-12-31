package com.restrohub.qrmenu.branch.repository;

import com.restrohub.qrmenu.branch.entity.Branch;
import com.restrohub.qrmenu.restaurant.entity.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    
    List<Branch> findByIsDeleteFalse();
    
    Optional<Branch> findByBranchIdAndIsDeleteFalse(Long branchId);

    // Get all branches for a restaurant
    List<Branch> findByRestaurant(Restaurant restaurant);

    // Get all branches by restaurant ID
    List<Branch> findByRestaurant_RestId(Long restId);

    // Count branches under a restaurant
    long countByRestaurant_RestId(Long restId);

    // Check if a branch name already exists for a restaurant
    boolean existsByNameAndRestaurant_RestId(String branchName, Long restId);
}
