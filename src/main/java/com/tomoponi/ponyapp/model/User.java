package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;
    @NonNull
    String username;
    @NonNull
    String email;
    @NonNull
    String password;

    // constructor to create a new user with an empty bag
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.bag = new Bag(0);
    }

    // each user has a personal bag/inventory only they can see and access
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    Bag bag;

    // each user can have multiple pets to care for
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Pet> pets = new LinkedHashSet<>();
}
