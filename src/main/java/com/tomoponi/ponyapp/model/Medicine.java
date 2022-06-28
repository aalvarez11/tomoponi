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
public class Medicine extends Item {
    int restorationAmount;

    public Medicine(String name, String description, String image, int buyPrice, int sellPrice, int restorationAmount) {
        super(name, description, image, buyPrice, sellPrice);
        this.restorationAmount = restorationAmount;
    }

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
