// com/restro/qrmenu/food/entity/Food.java
package com.restrohub.qrmenu.food.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.restrohub.qrmenu.category.entity.Category;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "t_food_master", indexes = {
        @Index(name = "idx_food_name", columnList = "name"),
//        @Index(name = "idx_food_category", columnList = "category"),
        @Index(name = "idx_food_available", columnList = "isAvailable")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "foodId")
@SQLDelete(sql = "UPDATE foods SET is_delete = true WHERE id = ?")
@SQLRestriction("is_delete = false")
public class Food  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "isAvailable",nullable = false)
    @Builder.Default
    private Boolean isAvailable = true;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_veg")
    @Builder.Default
    private Boolean isVeg = true;

    @Column(name = "is_delete")
    @Builder.Default
    private Boolean isDelete = false;

    @ManyToMany
    @JoinTable(
        name = "T_rel_foodCat",
        joinColumns = @JoinColumn(name = "food_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Builder.Default
    private Set<Category> categories = new HashSet<>();

    @PrePersist // this automaticatically add dateCreated and updatedDate when new entity added
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate // this automaticatically update updatedDate when existing entity update
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

}