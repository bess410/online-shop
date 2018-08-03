package com.epam.andrei_sterkhov.online_shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String userName;
    private String surname;
    private String login;
    private String pass;
    private int discount = 10;
    /*private List<Item> basket = new ArrayList<>();

    public int getSum() {
        return basket.stream().map(Item::getPrice).mapToInt(Integer::intValue).sum();
    }

    public int getSumDiscount() {
        return getSum() * discount / 100;
    }

    public int getSumToPay() {
        return getSum() - getSumDiscount();
    }*/
}
