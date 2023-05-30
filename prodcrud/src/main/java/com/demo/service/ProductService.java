package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.demo.entity.Category;
import com.demo.entity.Product;

public interface ProductService {
	Product createProduct(Product product );
	Product  getProductById(Integer id);
    List<Product > getAllProduct();
    void deleteProduct (Integer id);
    Optional<Product> updateProduct (Product product,Integer id);
}
