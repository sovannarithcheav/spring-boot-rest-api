package com.res.api.service;

import com.res.api.model.entity.Restaurant;

import java.util.List;

public interface IRestaurantService {

    List<Restaurant> getRestaurants(String name, String itemName, String address);

}
