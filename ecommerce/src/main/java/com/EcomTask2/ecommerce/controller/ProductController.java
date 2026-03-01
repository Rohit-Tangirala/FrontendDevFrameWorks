package com.EcomTask2.ecommerce.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.EcomTask2.ecommerce.model.Product;
import com.EcomTask2.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll(){
        return service.getAllProducts();
    }

    @PostMapping
    public Product add(@RequestBody Product p){
        return service.save(p);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p){

        Product existing = service.getById(id);

        existing.setOriginalPrice(p.getOriginalPrice());
        existing.setDeliveryPrice(p.getDeliveryPrice());
        existing.setQuantity(p.getQuantity());

        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
