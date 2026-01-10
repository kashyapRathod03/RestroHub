package com.restrohub.qrmenu.food.dto;

import com.restrohub.qrmenu.common.generic.GenericMapper;
import com.restrohub.qrmenu.food.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface FoodMapper extends GenericMapper<Food,FoodRequestDTO,FoodResponseDTO,FoodUpdateDTO> {
}
