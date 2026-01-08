package com.restrohub.qrmenu.template.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("CONTACT")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ContactInfoSection extends RestaurantSection {

    // Location block
    @Column(length=80)
    private String locationTitle;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String locationLinesJson; // store JSON array string: ["line1","line2"]

    @Column(length=700)
    private String mapUrl;

    // Hours block
    @Column(length=80)
    private String hoursTitle;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String hoursLinesJson; // JSON array string

    // Contact block
    @Column(length=80)
    private String contactTitle;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String contactLinesJson; // JSON array string
}