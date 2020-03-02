package com.res.api.controller;

import com.res.api.model.entity.Restaurant;
import com.res.api.model.response.Response;
import com.res.api.service.impl.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private RestaurantService restaurantService;

    MainController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurant")
    public ResponseEntity<Object> getRestaurant(
            @RequestParam(value = "shopName", required = false) String name
            , @RequestParam(value = "itemName", required = false) String itemName
            , @RequestParam(value = "address", required = false) String address) {

        List<Restaurant> restaurants = restaurantService.getRestaurants(name, itemName, address);
        Response response = new Response();
        response.setSuccess(restaurants);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
