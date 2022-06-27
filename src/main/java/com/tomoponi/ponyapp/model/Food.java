package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue(value = "FOOD")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food extends Item {
    int fillAmount;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "bag_bag_id")
    private Bag bag;

    @Override
    public String toString() {
        return "Food{" +
                "fillAmount=" + fillAmount +
                "} " + super.toString();
    }
}
