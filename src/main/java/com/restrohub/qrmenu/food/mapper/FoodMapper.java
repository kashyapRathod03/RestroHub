// src/main/java/com/restrohub/qrmenu/food/mapper/FoodMapper.java
package com.restrohub.qrmenu.food.mapper;

import com.restrohub.qrmenu.common.generic.PageResponseDTO;
import com.restrohub.qrmenu.food.dto.*;
import com.restrohub.qrmenu.food.entity.Food;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FoodMapper {

    Food toEntity(FoodRequestDTO requestDTO);

    FoodResponseDTO toResponseDTO(Food food);

    List<FoodResponseDTO> toResponseDTOList(List<Food> foods);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(FoodUpdateDTO updateDTO, @MappingTarget Food food);

    default PageResponseDTO<FoodResponseDTO> toPageResponseDTO(Page<Food> foodPage) {
        return PageResponseDTO.<FoodResponseDTO>builder()
                .content(toResponseDTOList(foodPage.getContent()))
                .pageNumber(foodPage.getNumber())
                .pageSize(foodPage.getSize())
                .totalElements(foodPage.getTotalElements())
                .totalPages(foodPage.getTotalPages())
                .first(foodPage.isFirst())
                .last(foodPage.isLast())
                .empty(foodPage.isEmpty())
                .build();
    }
}