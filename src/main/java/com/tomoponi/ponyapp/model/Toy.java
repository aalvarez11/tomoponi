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
@DiscriminatorValue(value = "TOY")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Toy extends Item {
    int joyAmount;

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
