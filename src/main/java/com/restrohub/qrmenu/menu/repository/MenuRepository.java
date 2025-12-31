package com.restrohub.qrmenu.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restrohub.qrmenu.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}

