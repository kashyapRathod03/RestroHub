package com.restrohub.qrmenu.template.entity;

import jakarta.persistence.*;
import lombok.*;

// -------------------------
// Base Section (Pattern)
// - Single-table inheritance keeps schema simple and scalable.
// - Each concrete section is a "type" row.
// - You can add new sections by adding a new subclass only.
// -------------------------
@Entity
@Table(name = "restaurant_sections",
        indexes = {
                @Index(name="idx_sections_restaurant", columnList = "restaurant_id"),
                @Index(name="idx_sections_type", columnList = "section_type")
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "section_type", discriminatorType = DiscriminatorType.STRING, length = 40)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public abstract class RestaurantSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many sections belong to a restaurant appearance
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id", nullable=false,
            foreignKey = @ForeignKey(name="fk_section_restaurant_appearance"))
    private RestaurantAppearance appearance;

    // e.g. "brand", "about", "gallery", "contact", "social"
    // Useful for frontend mapping (and for admin UI)
    @Column(name = "section_key", nullable = false, length = 60)
    private String sectionKey;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "sort_order", nullable = false)
    private int sortOrder = 0;
}