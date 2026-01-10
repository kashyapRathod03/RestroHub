package com.restrohub.qrmenu.restaurant.mapper;

import com.restrohub.qrmenu.common.generic.GenericMapper;
import com.restrohub.qrmenu.restaurant.dto.RestaurantRequestDTO;
import com.restrohub.qrmenu.restaurant.dto.RestaurantResponseDTO;
import com.restrohub.qrmenu.restaurant.dto.RestaurantUpdateDTO;
import com.restrohub.qrmenu.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantRequestDTO, RestaurantResponseDTO, RestaurantUpdateDTO> {
}
