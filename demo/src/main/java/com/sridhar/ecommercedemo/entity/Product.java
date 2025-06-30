package com.sridhar.ecommercedemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// second file.
@Entity
@Table(name="Product")
@Data
@AllArgsConstructor
@Builder
public class Product {
    public Product()
    {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer id;
    @Column(name="Name")
    private String name;
    @Column(name="Description")
    private String description;
    @Column(name="Price")
    private Long  price;
    @Column(name="PictureUrl")
    private String PictureUrl;
    //establish many products can be assosciate with a brand , establish many to one
    // fetch type is lazy , not the eager type.
    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name="ProductBrandId", referencedColumnName = "Id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ProductTypeId", referencedColumnName = "Id")
    private Type type;



}
