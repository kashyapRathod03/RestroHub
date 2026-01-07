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
@Schema(description = "Restaurant create request payload")
public class RestaurantRequestDTO {

    @Schema(description = "Name of the restaurant", example = "Restroly")
    private String name;

    @Schema(description = "Short description of the restaurant",
            example = "A modern multi-cuisine restaurant")
    private String description;

    @Schema(description = "Contact phone number of the restaurant",
            example = "+91-9876543210")
    private String phoneNumber;

//    private List<Branch> branches;

    @Builder.Default
    private Boolean isActive = true;

}
