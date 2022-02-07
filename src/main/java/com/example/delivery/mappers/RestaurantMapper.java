package com.example.delivery.mappers;


import com.example.delivery.domain.Restaurant;
import com.example.delivery.dto.RestaurantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO toDTO(Restaurant restaurant);

    List<RestaurantDTO> RestaurantsToRestaurantsDTO(List<Restaurant> restaurants);
}
