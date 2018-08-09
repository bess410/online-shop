package com.epam.andrei_sterkhov.online_shop.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemIntoBasket {
    private Long id;

    private User user;

    private Item item;
    private int amount;

    public int getSum() {
        return item.getPrice() * amount;
    }
}
