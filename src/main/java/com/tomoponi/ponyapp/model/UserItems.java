package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int qty;

    // constructor
    public UserItems(User user, Item item) {
        this.user = user;
        this.item = item;
        this.qty = 1; // by default, users will get 1 of an item
    }

    public UserItems(User user, Item item, int quantity) {
        this.user = user;
        this.item = item;
        this.qty = quantity; // bulk getting items needs a diff constructor
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "item_id")
    private Item item;

}
