package com.tomoponi.ponyapp.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue(value = "TOY")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Toy extends Item {
    int joyAmount;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "bag_bag_id")
    private Bag bag;

    public Toy(String name, String description, String image, int buyPrice, int sellPrice, int joyAmount) {
        super(name, description, image, buyPrice, sellPrice);
        this.joyAmount = joyAmount;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "joyAmount=" + joyAmount +
                "} " + super.toString();
    }
}
