package com.example.ProductService.Service;


import com.example.ProductService.Model.Product;
import com.example.ProductService.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Add a new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete a product by ID
    public void deleteProduct(Long productid) {
        productRepository.deleteById(productid);
    }

    // Update product details
    public Product updateProduct(Long productid, Product productDetails) {
        Product product = getProduct(productid);
        product.setProductName(productDetails.getProductName());
        product.setProductDescription(productDetails.getProductDescription());
        product.setProductPrice(productDetails.getProductPrice());
        return productRepository.save(product);
    }

    // Get product by ID
    public Product getProduct(Long productid) {
        Optional<Product> product = productRepository.findById(productid);
        return product.orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Search products by name
    public List<Product> searchProduct(String productName) {
        return productRepository.findAll().stream()
                .filter(product -> product.getProductName().contains(productName))
                .toList();
    }
}
