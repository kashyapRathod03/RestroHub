package com.restroly.qrmenu.food.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Food creation request payload")

public class FoodRequestDTO {

    @Size(min = 2, max = 100, message = "Food name must be between 2 and 100 characters")
    @Schema(description = "Name of the food item", example = "Margherita Pizza")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Schema(description = "Detailed description of the food item")
    private String description;

    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @DecimalMax(value = "9999.99", message = "Price cannot exceed 9999.99")
    @Digits(integer = 4, fraction = 2, message = "Price must have at most 4 integer digits and 2 decimal places")
    @Schema(description = "Price of the food item", example = "14.99")
    private BigDecimal price;

    @Size(min = 1, max = 50, message = "Category must be between 1 and 50 characters")
    @Schema(description = "Category of the food item", example = "Pizza")
    private String category;

    @Size(max = 255, message = "Image URL cannot exceed 255 characters")
    @Pattern(regexp = "^(https?://.*)?$", message = "Image URL must be a valid HTTP/HTTPS URL")
    @Schema(description = "URL of the food item image")
    private String imageUrl;

    @Schema(description = "Whether the food item is currently available")
    private Boolean isAvailable;

    @Schema(description = "Whether the food item is vegetarian")
    private Boolean isVeg;

    @Schema(description = "Whether the food item is need to delete")
    private Boolean isDelete;

}
