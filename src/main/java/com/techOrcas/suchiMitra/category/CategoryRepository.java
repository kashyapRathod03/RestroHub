package com.techOrcas.suchiMitra.category;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByMenu_MenuId(long menuId);

    List<Category> findByIsDeletedFalse();
}

