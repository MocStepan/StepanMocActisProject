package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* Tato třída poskytuje službu pro práci s Produkty a repozitářem
*/
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /*
     * Konstruktor třídy ProductServices
     */
    public ProductService() {
    }

    /*
    * Metoda, která po zavolání a předání parametru, uloží produkty do databáze
    * @param productList Seznam produktů, které mají být uloženy
    * */
    public void setAllProducts(List<Product> productList){
        productRepository.saveAll(productList);
    }

    /*
    * Vrátí seznam všech produktů z databáze
    * @return Seznam všech produktů
    * */
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
}
