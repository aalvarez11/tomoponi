package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food extends Item {
    int fillAmount;

    public Food(String name, String description, String image, int buyPrice, int sellPrice, int fillAmount) {
        super(name, description, image, buyPrice, sellPrice);
        this.fillAmount = fillAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return fillAmount == food.fillAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fillAmount);
    }
}
