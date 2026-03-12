package com.EcomTask2.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.EcomTask2.ecommerce.model.CartItem;
import com.EcomTask2.ecommerce.model.Product;
import com.EcomTask2.ecommerce.repository.CartRepository;
import com.EcomTask2.ecommerce.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    // ✅ ADD TO CART + REDUCE STOCK IMMEDIATELY
    public String addToCart(Long userId, Long productId){

        Product product = productRepo.findById(productId).orElse(null);

        if(product == null)
            return "Product not found";

        //  prevent adding if stock = 0
        if(product.getQuantity() <= 0)
            return "Out of Stock";

        // reduce stock immediately
        product.setQuantity(product.getQuantity() - 1);
        productRepo.save(product);

        // check if already in cart
        List<CartItem> items = cartRepo.findByUserId(userId);

        for(CartItem item : items){
            if(item.getProductId().equals(productId)){
                item.setQuantity(item.getQuantity() + 1);
                cartRepo.save(item);
                return "Added to Cart";
            }
        }

        CartItem newItem = new CartItem();
        newItem.setUserId(userId);
        newItem.setProductId(productId);
        newItem.setQuantity(1);

        cartRepo.save(newItem);

        return "Added to Cart";
    }

    public List<CartItem> getUserCart(Long userId){
        return cartRepo.findByUserId(userId);
    }

    //  PURCHASE → JUST CLEAR CART (stock already reduced)
    public void purchase(Long userId){

        List<CartItem> cartItems = cartRepo.findByUserId(userId);

        if(cartItems == null || cartItems.isEmpty()){
            return;  // nothing to purchase
        }

        // Just clear cart (stock already reduced earlier)
        cartRepo.deleteByUserId(userId);
    }

    //  REMOVE ITEM → RETURN STOCK BACK
    public void removeItem(Long cartId){

        CartItem item = cartRepo.findById(cartId).orElse(null);

        if(item != null){
            Product product = productRepo.findById(item.getProductId()).orElse(null);

            if(product != null){
                product.setQuantity(product.getQuantity() + item.getQuantity());
                productRepo.save(product);
            }

            cartRepo.deleteById(cartId);
        }
    }
}