package com.restrohub.qrmenu.template.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gallery_images",
        indexes = @Index(name="idx_gallery_section", columnList = "gallery_section_id"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class GalleryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // each image belongs to a gallery section
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gallery_section_id", nullable=false,
            foreignKey = @ForeignKey(name="fk_gallery_image_section"))
    private GallerySection gallerySection;

    @Column(nullable=false, length=700)
    private String src;

    @Column(length=160)
    private String alt;

    // e.g. "large", "normal", "wide"
    @Column(length=20)
    private String span;

    @Column(nullable=false)
    private int sortOrder = 0;
}