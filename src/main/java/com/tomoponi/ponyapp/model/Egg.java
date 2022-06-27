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
@DiscriminatorValue(value = "EGG")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Egg extends Item {
    int hatchTime;
    @Enumerated(value = EnumType.STRING)
    ElementType element;

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
