package com.res.api.model.entity;

import com.res.api.constant.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant")
@AttributeOverride(name = "id", column = @Column(name = "restaurant_id"))
@Setter
@Getter
@NoArgsConstructor
public class Restaurant extends Base<Integer> {

    private static final long serialVersionUID = 4333545986466452064L;

    public Restaurant(String name, Location location, List<Item> items) {
        this.name = name;
        this.location = location;
        this.items = items;
        this.setStatus(Status.ACTIVE);
    }

    @Column(name = "shop_name")
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location__id", referencedColumnName = "location_id")
    private Location location;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant__id")
    private List<Item> items;

}
