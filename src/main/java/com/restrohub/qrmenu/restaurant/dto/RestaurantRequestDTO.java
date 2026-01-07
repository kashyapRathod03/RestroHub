package com.restrohub.qrmenu.restaurant.dto;

import com.restrohub.qrmenu.branch.entity.Branch;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Restaurant creation request payload")
public class RestaurantRequestDTO {

    private String name;

    private String description;

    private String phoneNumber;

    private List<Branch> branches;

    @Builder.Default
    private Boolean isActive = true;

}
