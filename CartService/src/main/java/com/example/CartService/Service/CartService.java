package com.example.CartService.Service;


import com.example.CartService.Model.Cart;
import com.example.CartService.Repo.CartRepository;
import com.example.CartService.Repo.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    // Add Cart (with LineItems)
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Empty the cart by removing all line items
    public void emptyCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setLineItems(null); // Empty cart
        cartRepository.save(cart);
    }

    // Update Cart
    public Cart updateCart(Long cartId, Cart updatedCart) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setLineItems(updatedCart.getLineItems());
        return cartRepository.save(cart);
    }

    // Search Cart
    public Cart searchCart(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}
