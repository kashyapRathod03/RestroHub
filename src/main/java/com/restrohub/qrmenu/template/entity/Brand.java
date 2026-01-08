package com.restrohub.qrmenu.template.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("BRAND")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Brand extends RestaurantSection {

    // Match your defaultData.brand
    @Column(nullable=false, length=80)
    private String name;

    @Column(length=160)
    private String fullName;

    @Column(length=255)
    private String tagline;

    @Column(length=80)
    private String established;

    @Column(length=500)
    private String logo; // store URL/path; keep String to stay generic
}
