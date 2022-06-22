package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.DiscriminatorValue;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue(value = "EGG")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Egg extends Item {
    int hatchTime;
    @Enumerated(value = EnumType.STRING)
    ElementType element;

    public Egg(String name, String description, String image, int buyPrice, int sellPrice, int hatchTime, ElementType element) {
        super(name, description, image, buyPrice, sellPrice);
        this.hatchTime = hatchTime;
        this.element = element;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "hatchTime=" + hatchTime +
                ", element=" + element +
                "} " + super.toString();
    }
}
