package com.epam.andrei_sterkhov.online_shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
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

