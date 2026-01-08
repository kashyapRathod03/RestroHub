package com.restrohub.qrmenu.template.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("SOCIAL")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SocialSection extends RestaurantSection {

    @OneToMany(mappedBy = "socialSection", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("sortOrder ASC")
    @Builder.Default
    private List<SocialLink> links = new ArrayList<>();

    public void addLink(SocialLink link) {
        link.setSocialSection(this);
        links.add(link);
    }

    public void removeLink(SocialLink link) {
        links.remove(link);
        link.setSocialSection(null);
    }
}
