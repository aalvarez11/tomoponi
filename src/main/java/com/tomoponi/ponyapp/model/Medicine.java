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
@DiscriminatorValue(value = "MEDICINE")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Medicine extends Item {
    int restorationAmount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medicine medicine = (Medicine) o;
        return restorationAmount == medicine.restorationAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), restorationAmount);
    }
}
