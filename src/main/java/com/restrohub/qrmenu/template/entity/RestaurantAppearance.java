package com.restrohub.qrmenu.template.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// -------------------------
// RestaurantAppearance
// One row per restaurant selects template + theme
// and contains dynamic, extensible sections.
// -------------------------
@Entity
@Table(name = "restaurant_appearance")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RestaurantAppearance {

    @Id
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "template_id", nullable=false,
            foreignKey = @ForeignKey(name="fk_restaurant_appearance_template"))
    private Template template;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "theme_id", nullable=false,
            foreignKey = @ForeignKey(name="fk_restaurant_appearance_theme"))
    private Theme theme;

    // Custom theme overrides (JSON) - allows per-restaurant customization
    @Column(name = "theme_overrides", columnDefinition = "TEXT")
    private String themeOverridesJson;

    // Custom CSS
    @Column(name = "custom_css", columnDefinition = "TEXT")
    private String customCss;

    // Global settings
    @Column(name = "favicon_url")
    private String faviconUrl;

    // Dynamic sections (add/remove freely)
    @OneToMany(mappedBy = "appearance", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("sortOrder ASC")
    @Builder.Default
    private List<RestaurantSection> sections = new ArrayList<>();

    // Convenience helpers
    public void addSection(RestaurantSection section) {
        section.setAppearance(this);
        this.sections.add(section);
    }

    public void removeSection(RestaurantSection section) {
        this.sections.remove(section);
        section.setAppearance(null);
    }
}