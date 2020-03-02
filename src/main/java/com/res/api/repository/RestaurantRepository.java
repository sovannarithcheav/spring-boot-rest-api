package com.res.api.repository;

import com.res.api.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    /**
     * All param default value is '' and can not be null
     *
     * @param name
     * @param itemName
     * @param address
     * @return
     */
    @Query(value = "SELECT distinct r FROM Restaurant r" +
            " LEFT JOIN FETCH r.items i" +
            " LEFT JOIN FETCH r.location l" +
            " WHERE (UPPER(r.name) LIKE UPPER('%'||:name||'%') OR :name = '')" +
            "  AND (UPPER(i.name) LIKE UPPER('%'||:itemName||'%') OR :itemName = '')" +
            "  AND (UPPER(l.address) LIKE UPPER('%'||:address||'%') OR :address = '')" +
            "  AND r.status = 'ACT' AND i.status = 'ACT' AND l.status = 'ACT'")
    List<Restaurant> searchRestaurant(@Param("name") String name, @Param("itemName") String itemName, @Param("address") String address);

}
