package com.techOrcas.suchiMitra.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    // Get all branches for a restaurant
    List<Branch> findByRestaurant(Restaurant restaurant);

    // Get all branches by restaurant ID
    List<Branch> findByRestaurant_RestId(Long restId);

    // Count branches under a restaurant
    long countByRestaurant_RestId(Long restId);

    // Check if a branch name already exists for a restaurant
    boolean existsByBranchNameAndRestaurant_RestId(String branchName, Long restId);
}
