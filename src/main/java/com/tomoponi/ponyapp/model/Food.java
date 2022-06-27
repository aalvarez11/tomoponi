package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@DiscriminatorValue(value = "FOOD")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food extends Item {
    int fillAmount;

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
