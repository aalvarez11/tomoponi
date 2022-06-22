package com.tomoponi.ponyapp.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue(value = "EGG")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Medicine extends Item {
    int restorationAmount;

    public Medicine(String name, String description, String image, int buyPrice, int sellPrice, int restorationAmount) {
        super(name, description, image, buyPrice, sellPrice);
        this.restorationAmount = restorationAmount;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "restorationAmount=" + restorationAmount +
                "} " + super.toString();
    }
}
