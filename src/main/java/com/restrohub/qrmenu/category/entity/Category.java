// com/restro/qrmenu/category/entity/Category.java
package com.restrohub.qrmenu.category.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.restrohub.qrmenu.food.entity.Food;

import com.restrohub.qrmenu.menu.entity.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_category_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Builder.Default
    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Builder.Default
    @ManyToMany(mappedBy = "categories")
    private Set<Food> foods = new HashSet<>();

    @Builder.Default
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Menu> menu = new HashSet<>();

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}