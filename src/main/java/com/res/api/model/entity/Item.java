package com.res.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.res.api.constant.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item")
@AttributeOverride(name = "id", column = @Column(name = "item_id"))
@Getter
@Setter
@NoArgsConstructor
public class Item extends Base<Long> {
    private static final long serialVersionUID = 5129358364799686030L;

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
        this.setStatus(Status.ACTIVE);
    }

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private Double price;

    @OneToOne
    @JoinColumn(name = "restaurant__id", referencedColumnName = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;
}
