package com.EcomTask2.ecommerce.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import java.util.*;
import com.EcomTask2.ecommerce.service.CartService;
import com.EcomTask2.ecommerce.model.CartItem;

import com.EcomTask2.ecommerce.model.Product;
import com.EcomTask2.ecommerce.repository.CartRepository;
import com.EcomTask2.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService service;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CartRepository cartRepo;

    // ✅ ADD TO CART
    @PostMapping("/add/{userId}/{productId}")
    public String addToCart(@PathVariable Long userId,
                            @PathVariable Long productId){

        return service.addToCart(userId, productId);
    }

    // ✅ GET USER CART WITH PRODUCT DETAILS
    @GetMapping("/{userId}")
    public List<Map<String, Object>> getCart(@PathVariable Long userId) {

        List<CartItem> cartItems = service.getUserCart(userId);
        List<Map<String, Object>> response = new ArrayList<>();

        for (CartItem item : cartItems) {

            Product p = productRepo.findById(item.getProductId()).orElse(null);

            if (p != null) {

                Map<String, Object> map = new HashMap<>();

                map.put("cartId", item.getId());
                map.put("productId", p.getId());
                map.put("productName", p.getItemName());
                map.put("price", p.getDeliveryPrice());
                map.put("quantity", item.getQuantity());
                map.put("subtotal", p.getDeliveryPrice() * item.getQuantity());

                response.add(map);
            }
        }

        return response;
    }

    // ✅ REMOVE ITEM FROM CART
    @DeleteMapping("/remove/{cartId}")
    public void removeItem(@PathVariable Long cartId){
        service.removeItem(cartId);
    }

    // ✅ PURCHASE (REDUCE STOCK + CLEAR CART)
    @PostMapping("/purchase/{userId}")
    public void purchase(@PathVariable Long userId) {

        service.purchase(userId);
    }
}