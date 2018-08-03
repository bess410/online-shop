package com.epam.andrei_sterkhov.online_shop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}

