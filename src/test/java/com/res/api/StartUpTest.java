package com.res.api;

import com.res.api.model.entity.Item;
import com.res.api.model.entity.Location;
import com.res.api.model.entity.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StartUpTest {
    public List<Restaurant> list = new ArrayList<>();
    Item itemA1 = new Item("Coca", 0.5);
    Item itemA2 = new Item("Water", 0.3);
    Item itemA3 = new Item("Spy Red", 2.3);
    Item itemA4 = new Item("Orange Juice", 2.0);
    Item itemA5 = new Item("Watermelon Juice", 2.0);
    Item itemA6 = new Item("Passion Fruit Juice", 2.0);
    Item itemA7 = new Item("Lotus Water", 2.0);
    Item itemA8 = new Item("Diet Coke", 2.5);
    Location locationA = new Location("location a");
    Restaurant restaurantA = new Restaurant("Shop A", locationA, Arrays.asList(itemA1, itemA2, itemA3, itemA4, itemA5, itemA6, itemA7, itemA8));

    Item itemB1 = new Item("Sweet Potato Fries", 2.0);
    Item itemB2 = new Item("Buffalo Wings", 6.5);
    Item itemB3 = new Item("Raw Vegetable & Herb Bouquet", 1.5);
    Item itemB4 = new Item("Crisp Mussels & Tartar Sauce", 1.9);
    Item itemB5 = new Item("Scotch Egg", 1.5);
    Item itemB6 = new Item("Smoked Haddock Frittata", 3.5);
    Item itemB7 = new Item("Rare Roast Beef Yorkies", 2.9);
    Location locationB = new Location("location b");
    Restaurant restaurantB = new Restaurant("Shop B", locationB, Arrays.asList(itemB1, itemB2, itemB3, itemB4, itemB5, itemB6, itemB7));


    Item itemC1 = new Item("Cafe Ice Latte", 2.5);
    Item itemC2 = new Item("Cafe Mocha", 2.0);
    Item itemC3 = new Item("Honey Aloe Vera", 2.0);
    Item itemC4 = new Item("Ice Cream Chocolate", 2.0);
    Item itemC5 = new Item("Green Tea Macchilato", 2.5);
    Item itemC6 = new Item("Mocha Frappe", 2.0);
    Location locationC = new Location("location c");
    Restaurant restaurantC = new Restaurant("Shop C", locationC, Arrays.asList(itemC1, itemC2, itemC3, itemC4, itemC5, itemC6));


    Item itemD1 = new Item("Fried Rice", 3.5);
    Item itemD2 = new Item("Rice & Beans", 2.0);
    Item itemD3 = new Item("Pasta Papu", 5.5);
    Item itemD4 = new Item("Crispy Chicken", 4.5);
    Location locationD = new Location("location d");
    Restaurant restaurantD = new Restaurant("Shop D", locationD, Arrays.asList(itemD1, itemD2, itemD3, itemD4));

    public void init() throws Exception {
        list.add(restaurantA);
        list.add(restaurantB);
        list.add(restaurantC);
        list.add(restaurantD);
    }

    public List<Restaurant> getListContainJuice() {
        list.get(0).setItems(Arrays.asList(itemA6, itemA4, itemA5));
        return Collections.singletonList(list.get(0));
    }

}
