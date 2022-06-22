package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue(value = "FOOD")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food extends Item {
    int fillAmount;

    public Food(String name, String description, String image, int buyPrice, int sellPrice, int fillAmount) {
        super(name, description, image, buyPrice, sellPrice);
        this.fillAmount = fillAmount;
    }

    @Override
    public String toString() {
        return "Food{" +
                "fillAmount=" + fillAmount +
                "} " + super.toString();
    }
}
