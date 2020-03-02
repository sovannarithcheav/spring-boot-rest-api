package com.res.api.service.impl;

import com.res.api.StartUpTest;
import com.res.api.model.entity.Restaurant;
import com.res.api.repository.RestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

    @InjectMocks
    RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    StartUpTest startUpTest = new StartUpTest();
    String KEY_SEARCH = "Juice";

    @BeforeEach
    void init() throws Exception {
        startUpTest.init();
    }

    @DisplayName("Test Get List Restaurant with Empty params and return all elements")
    @Test
    void test_get_empty_param_OK() {
        when(restaurantRepository.searchRestaurant("", "", "")).thenReturn(startUpTest.list);
        List<Restaurant> restaurants = restaurantService.getRestaurants("", "", "");
        Assertions.assertNotNull(restaurants);
    }

    @DisplayName("Test Get List Restaurant with Null params and return all elements")
    @Test
    void test_get_null_param_OK() {
        when(restaurantRepository.searchRestaurant("", "", "")).thenReturn(startUpTest.list);
        List<Restaurant> restaurants = restaurantService.getRestaurants(null, null, null);
        Assertions.assertNotNull(restaurants);
    }

    @DisplayName("Test Get List Restaurant with Null params and return all elements")
    @Test
    void test_get_restaurant_by_item_name_OK() {
        when(restaurantRepository.searchRestaurant("", KEY_SEARCH, "")).thenReturn(startUpTest.getListContainJuice());
        List<Restaurant> restaurants = restaurantService.getRestaurants("", KEY_SEARCH, "");
        Assertions.assertNotNull(restaurants);
        Assertions.assertTrue(restaurants.get(0).getItems().get(0).getName().contains(KEY_SEARCH));
    }

}