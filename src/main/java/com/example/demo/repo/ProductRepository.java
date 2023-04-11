package com.example.demo.repo;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* Rozhraní, které má předdefinované metody pro práci s entitou Product uložené v databázi
* */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
