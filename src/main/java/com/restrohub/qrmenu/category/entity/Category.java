// com/restro/qrmenu/category/entity/Category.java
package com.restrohub.qrmenu.category.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.restrohub.qrmenu.food.entity.Food;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
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

    @Column(name = "is_delete")
    @Builder.Default
    private Boolean isDelete = false;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @ManyToMany(mappedBy = "categories")
    @Builder.Default
    private Set<Food> foods = new HashSet<>();

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "menu_id")
    // private Menu menu;


    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}