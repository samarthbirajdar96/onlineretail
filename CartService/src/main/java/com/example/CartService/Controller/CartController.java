package com.example.CartService.Controller;


import com.example.CartService.Model.Cart;
import com.example.CartService.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Create a new cart
    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.addCart(cart);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    // Empty the cart (after placing an order)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> emptyCart(@PathVariable Long id) {
        cartService.emptyCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Update cart details
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart updatedCart) {
        Cart cart = cartService.updateCart(id, updatedCart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    // Get cart details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> searchCart(@PathVariable Long id) {
        Cart cart = cartService.searchCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
