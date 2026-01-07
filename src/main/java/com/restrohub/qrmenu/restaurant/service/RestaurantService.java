package com.restrohub.qrmenu.restaurant.service;

import com.restrohub.qrmenu.restaurant.dto.RestaurantRequestDTO;
import com.restrohub.qrmenu.restaurant.dto.RestaurantResponseDTO;
import com.restrohub.qrmenu.restaurant.dto.RestaurantUpdateDTO;

public interface RestaurantService {

    RestaurantResponseDTO createRestaurant(RestaurantRequestDTO requestDTO);

    RestaurantResponseDTO getRestaurantById(Long id);

    RestaurantResponseDTO getRestaurantByName(String name);

    RestaurantResponseDTO updateRestaurant(Long id, RestaurantUpdateDTO updateDTO);

    void deleteRestaurant(Long id);

}
