package com.bitsnbytes.productlist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private String price;

    @ManyToOne
    @JoinColumn(name = "category_id" , nullable = false)   // is product walle table me category_id hoga or iski walue , category wale table ke id ko store karega
    //matlab , category_id ye ek foreign key hai is product table me , leking yehi primary key hai in category table me
    private  Category category;

}
