package com.example.micro1.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro1.product.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
