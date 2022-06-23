package com.tomoponi.ponyapp.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bag {
    @Id
    @Column(name = "BAG_ID")
    int bagId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "USER_ID")
    User user;
    int coins;

    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Egg> eggs = new ArrayList<>();

    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> foods = new ArrayList<>();

    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medicine> medicines = new ArrayList<>();

    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Toy> toys = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
