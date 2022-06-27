package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bag {
    @Id
    @NonNull
    @Column(name = "BAG_ID")
    int bagId;
    @NonNull
    int qty;

    @OneToOne(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    // many bags can have the same kind of item
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "item_id")
    private Item item;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return bagId == bag.bagId && Objects.equals(user, bag.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bagId, user);
    }
}
