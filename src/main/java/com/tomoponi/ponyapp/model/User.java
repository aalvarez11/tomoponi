package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.*;

@Entity
@Setter
@Getter
@ToString
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
    @Setter(AccessLevel.NONE)
    String password;
    @NonNull
    int coins;

    // password-encrypting constructor
    public User(@NonNull String username, @NonNull String email, @NonNull String password, @NonNull int coins) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.coins = coins;
    }

    // each user can have multiple pets to care for
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    Set<Pet> pets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<UserItems> userItemList = new ArrayList<>();

    // encrypting password setter
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    // hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && coins == user.coins && username.equals(user.username) && email.equals(user.email) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password);
    }

    // helper methods
    public void addPet(Pet p) {
        pets.add(p);
    }

    public void addItem(Item i) {
        userItemList.add(new UserItems(this, i));
    }

    public void addMultipleOfItem(Item i, int quantity) {
        userItemList.add(new UserItems(this, i, quantity));
    }
}
