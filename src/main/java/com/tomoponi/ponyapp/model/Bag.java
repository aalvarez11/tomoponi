package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bag {
    @Id
    @Column(name = "BAG_ID")
    int bagId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "USER_ID")
    User user;
    @NonNull
    int coins;

    // each bag can hold multiple eggs
    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Egg> eggs = new ArrayList<>();

    // each bag can hold multiple food items
    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> foods = new ArrayList<>();

    // each bag can hold multiple medicines
    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medicine> medicines = new ArrayList<>();

    // each bag can hold multiple toys
    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Toy> toys = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
