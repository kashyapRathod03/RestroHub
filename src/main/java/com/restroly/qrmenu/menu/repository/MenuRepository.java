package com.restroly.qrmenu.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restroly.qrmenu.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}

