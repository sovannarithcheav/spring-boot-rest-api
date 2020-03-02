package com.res.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.res.api.constant.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "location")
@AttributeOverride(name="id", column = @Column(name = "location_id"))
@Getter
@Setter@NoArgsConstructor
public class Location extends Base<Integer> {

    private static final long serialVersionUID = 1452900317692806087L;

    public Location(String address) {
        this.address = address;
        this.setStatus(Status.ACTIVE);
    }

    private String address;
    @OneToOne(mappedBy = "location")
    @JsonIgnore
    private Restaurant restaurant;

}
