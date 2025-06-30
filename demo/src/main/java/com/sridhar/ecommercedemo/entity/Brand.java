package com.sridhar.ecommercedemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

// first file
@Entity
@Table(name="Brand")
@Data
@AllArgsConstructor
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer id;
    @Column(name="Name")
    private String name;

    @OneToMany(mappedBy = "brand",fetch=FetchType.LAZY)
    private List<Product> products;


    public Brand()
    {

    }


}
