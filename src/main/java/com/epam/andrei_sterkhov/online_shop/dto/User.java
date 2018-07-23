package com.epam.andrei_sterkhov.online_shop.dto;

import com.epam.andrei_sterkhov.online_shop.enums.Role;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString
public class User{
    private String userName;
    private String surname;
    private String login;
    private String pass;
    private Role role = Role.CLIENT;
    private int discount = 10;
    private List<Item> busket = new ArrayList<>();

    public int getSum() {
        return busket.stream().map(Item::getPrice).mapToInt(Integer::intValue).sum();
    }

    public int getSumDiscount() {
        return getSum() * discount / 100;
    }

    public int getSumToPay() {
        return getSum() - getSumDiscount();
    }
}
