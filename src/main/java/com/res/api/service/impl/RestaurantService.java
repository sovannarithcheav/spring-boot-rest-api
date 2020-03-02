package com.res.api.service.impl;

import com.res.api.model.entity.Restaurant;
import com.res.api.repository.RestaurantRepository;
import com.res.api.service.IRestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RestaurantService implements IRestaurantService {

    RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getRestaurants(String name, String itemName, String address) {

        if (StringUtils.isEmpty(name)) name = "";
        if (StringUtils.isEmpty(itemName)) itemName = "";
        if (StringUtils.isEmpty(address)) address = "";

        return restaurantRepository.searchRestaurant(name, itemName, address);
    }
}
