package com.bitsnbytes.productlist.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // jaise hi categari me change kare to product bhi change hona chiye  --> 'CascadeType.ALL'
    // ise catogari se mapp karne ke liye , mappedBy = category
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;

}
