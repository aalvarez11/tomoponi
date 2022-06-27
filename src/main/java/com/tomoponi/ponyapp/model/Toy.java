package com.tomoponi.ponyapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@DiscriminatorValue(value = "TOY")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Toy extends Item {
    int joyAmount;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "bag_bag_id")
    private Bag bag;

}
