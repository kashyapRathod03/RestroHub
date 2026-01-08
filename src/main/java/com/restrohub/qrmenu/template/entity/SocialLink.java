package com.restrohub.qrmenu.template.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "social_links",
        indexes = @Index(name="idx_social_section", columnList = "social_section_id"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "social_section_id", nullable=false,
            foreignKey = @ForeignKey(name="fk_social_link_section"))
    private SocialSection socialSection;

    @Column(nullable=false, length=60)
    private String name;

    @Column(nullable=false, length=700)
    private String url;

    // match frontend "icon" string
    @Column(length=40)
    private String icon;

    @Column(nullable=false)
    private int sortOrder = 0;
}