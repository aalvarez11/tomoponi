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
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull
    String name;
    @NonNull
    String image;
    @NonNull
    int level;
    @NonNull
    int health;
    @NonNull
    int hunger;
    @NonNull
    int happiness;
    @Enumerated(value = EnumType.STRING)
    ElementType element;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    User user;

    public Pet(String name, String image, int level, int health, int hunger, int happiness, ElementType element) {
        this.name = name;
        this.image = image;
        this.level = level;
        this.health = health;
        this.hunger = hunger;
        this.happiness = happiness;
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return health == pet.health && level == pet.level && hunger == pet.hunger && happiness == pet.happiness && name.equals(pet.name) && image.equals(pet.image) && element == pet.element;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image, health, level, hunger, happiness, element);
    }
}
