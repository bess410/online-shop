package com.epam.andrei_sterkhov.online_shop.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "basket")
@Getter
@Setter
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private int amount;

    public int getSum() {
        return item.getPrice() * amount;
    }
}
