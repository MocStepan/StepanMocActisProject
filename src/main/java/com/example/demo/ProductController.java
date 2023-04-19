package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.services.ProductServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
* Třída ProductController je kontroler pro přístup k produktům v databázi.
* Obsahuje metody pro přídání a výpis produktů z databáze, také vytváří náhodné datum
* */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController() {
    }

    /*
    * Metoda, která se vyvolá při startu aplikace a uloží data do databáze
    *
    */
    @PostConstruct
    public void addProducts(){
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("Mléko",30,true, randomLocalDate()));
        productList.add(new Product("Chleba",50,false, randomLocalDate()));
        productList.add(new Product("Kuřecí prsa",240,false, randomLocalDate()));
        productServices.setAllProducts(productList);
    }

    /*
    * Metoda, která generuje náhodné datum v rozmezí:
    * Rok 2020-2023, měsíc 1-12 a den 1-x. X závisí na měsíci
    *
    * @return náhodné datum
    */
    public LocalDate randomLocalDate(){
        Random rd = new Random();
        int randomYear = rd.nextInt(2023-2020+1)+2020;
        int randomMonth = rd.nextInt(12)+1;
        YearMonth yearMonth = YearMonth.of(randomYear,randomMonth);
        int randomDay = rd.nextInt(yearMonth.lengthOfMonth())+1;
        return LocalDate.Of(randomYear, randomMonth, randomDay);
    }

    /*
    * Metoda, která vrací seznam všech produktů z databáze
    *
    * @return seznam produktů
    * */
    @GetMapping("/show")
    public List<Product> getProducts(){
        return productServices.findAllProducts();
    }


}
