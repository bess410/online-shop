package com.epam.andrei_sterkhov.online_shop.dto;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    private int amount;


    @ManyToOne
    @JoinColumn(name = "category_id_fk")
    private Category category;

    @Transient
    private Set<ItemIntoBasket> itemIntoBaskets = new HashSet<>();

}

