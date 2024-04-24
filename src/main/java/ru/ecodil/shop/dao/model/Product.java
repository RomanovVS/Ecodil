package ru.ecodil.shop.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    Long id;

    @Column(name = "PRODUCT_NAME")
    String productName;
    @Column(name = "PRICE")
    Double price;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "COUNTRY_OF_ORIGIN")
    String countryOfOrigin;
    @Column(name = "CATEGORY")
    String category;
    @Column(name = "IS_SHARED")
    Boolean isShared;
}
