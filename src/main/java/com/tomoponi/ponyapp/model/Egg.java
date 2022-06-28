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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Egg egg = (Egg) o;
        return hatchTime == egg.hatchTime && element == egg.element;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hatchTime, element);
    }
}
