package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;



/*
* Třída entity produkt, která bude uložena do databáze
* */
@Entity
@Table(name = "product")
public class Product {

    /*
    * Id produktu a název sloupce
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    /*
    * Název produktu a sloupce
    * */
    @Column(name = "product_name")
    private String name;

    /*
     * Cena produktu a název sloupce
     * */
    @Column(name = "product_price")
    private Integer price;

    /*
     * Zdali je produktu ve skladu a název sloupce
     * */
    @Column(name = "product_inStock")
    private Boolean inStock;

    /*
     * Kdy byl produk naposled naskladněn a název slooupce
     * */
    @Column(name = "product_LastStockDate")
    private LocalDate lastStockDate;

    public Product() {
    }

    /*
    * Konstruktor třídy pro vytvoření nového produktu
    * @param name Název produktu
    * @param price Cena produktu
    * @param inStock Jesli je ve skladu
    * @param lastStockDate Kdy byl naposled naskladněn
    * */
    public Product(String name, int price, boolean inStock, LocalDate lastStockDate) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.lastStockDate = lastStockDate;
    }


    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public LocalDate getDate() {
        return lastStockDate;
    }

    public void setDate(LocalDate LastStockDate) {
        this.lastStockDate = LastStockDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
