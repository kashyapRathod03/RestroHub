package com.restrohub.qrmenu.template.entity;

// ============================================
// Generic + Scalable Website Builder Model
// - Template: which React template to render
// - Theme: design tokens (colors, etc.)
// - RestaurantAppearance: per-restaurant selected template/theme + dynamic sections
// - Sections are dynamic via a Section registry pattern:
//      RestaurantSection (base) + concrete section entities (Brand/About/Contact/Social/Gallery)
// Add/remove sections without changing RestaurantAppearance schema.
// ============================================


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


// -------------------------
// Template
// -------------------------
@Entity
@Table(
        name = "templates",
        uniqueConstraints = @UniqueConstraint(name = "uk_template_key", columnNames = "template_key")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="template_key", nullable=false, length=80)
    private String templateKey; // React registry key (e.g. "adk_v1")

    @Column(nullable=false, length=120)
    private String name;

    @Column(name="preview_image_url")
    private String previewImageUrl;

    // Default configuration for this template (JSON)
    @Column(name = "default_config", columnDefinition = "TEXT")
    private String defaultConfigJson;

    @Column(name = "is_premium")
    private Boolean isPremium = false;

    @Column(nullable=false)
    private boolean active = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}