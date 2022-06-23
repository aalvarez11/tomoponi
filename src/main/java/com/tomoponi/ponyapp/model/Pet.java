package com.tomoponi.ponyapp.model;

import javax.persistence.*;

@Entity
public class Pet {
    @Id
    Long id;
    String image;
    int maxHP;
    int currHP;
    int level;
    int hunger;
    int happiness;
    ElementType element;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
