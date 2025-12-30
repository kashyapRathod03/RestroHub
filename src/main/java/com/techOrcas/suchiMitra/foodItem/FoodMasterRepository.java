package com.techOrcas.suchiMitra.foodItem;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodMasterRepository extends JpaRepository<FoodMaster, Long> {

    List<FoodMaster> findByIsDeletedFalse();

    List<FoodMaster> findByIsVegTrue();
}

