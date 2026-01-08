package com.restrohub.qrmenu.template.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("GALLERY")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class GallerySection extends RestaurantSection {

    @Column(length=80)
    private String subtitle;

    @Column(length=120)
    private String title;

    @OneToMany(mappedBy = "gallerySection", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("sortOrder ASC")
    @Builder.Default
    private List<GalleryImage> images = new ArrayList<>();

    public void addImage(GalleryImage img) {
        img.setGallerySection(this);
        images.add(img);
    }

    public void removeImage(GalleryImage img) {
        images.remove(img);
        img.setGallerySection(null);
    }
}