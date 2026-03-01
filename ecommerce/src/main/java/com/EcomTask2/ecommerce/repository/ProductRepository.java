package com.EcomTask2.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.EcomTask2.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}