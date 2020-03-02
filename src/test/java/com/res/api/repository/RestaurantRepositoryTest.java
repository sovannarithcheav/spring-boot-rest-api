package com.res.api.repository;

import com.res.api.StartUpTest;
import com.res.api.model.entity.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
class RestaurantRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @BeforeEach
    void init() throws Exception {
        StartUpTest startUpTest = new StartUpTest();
        startUpTest.init();
        startUpTest.list.forEach(restaurant -> testEntityManager.persist(restaurant));
    }

    @DisplayName("Test Get List Restaurant with Empty params and return all elements")
    @Test
    void test_get_empty_param_OK() {
        List<Restaurant> restaurants = restaurantRepository.searchRestaurant("", "", "");
        Restaurant restaurant = restaurants.get(0);
        Assertions.assertEquals(4, restaurants.size());
    }

    @DisplayName("Test Get List Restaurant with Null params and return all elements")
    @Test
    void test_get_restaurant_by_item_name_OK() {
        List<Restaurant> restaurants = restaurantRepository.searchRestaurant("", "Rice", "");
        Assertions.assertNotNull(restaurants);
    }

}