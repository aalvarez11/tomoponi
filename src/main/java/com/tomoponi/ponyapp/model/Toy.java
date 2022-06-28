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
public class Toy extends Item {
    int joyAmount;

    public Toy(String name, String description, String image, int buyPrice, int sellPrice, int joyAmount) {
        super(name, description, image, buyPrice, sellPrice);
        this.joyAmount = joyAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Toy toy = (Toy) o;
        return joyAmount == toy.joyAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), joyAmount);
    }
}
