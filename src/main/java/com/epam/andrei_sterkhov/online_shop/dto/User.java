package com.epam.andrei_sterkhov.online_shop.dto;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "client")
@Getter
@Setter
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "permission", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "basket", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Set<Item> basket = new HashSet<>();
/*
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
