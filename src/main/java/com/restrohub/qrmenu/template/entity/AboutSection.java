package com.restrohub.qrmenu.template.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("ABOUT")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AboutSection extends RestaurantSection {

    @Column(length=80)
    private String subtitle;

    @Column(length=160)
    private String titleLine1;

    @Column(length=160)
    private String titleLine2;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description1;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description2;

    @Column(length=500)
    private String imageUrl;

    // Optional: hours widget
    @Column(length=80)
    private String hoursTitle;

    @Column(length=80)
    private String hoursTime;
}