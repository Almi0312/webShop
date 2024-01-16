package com.ecorn.webshop.service;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    void addToUserBucket(Long productId, String username);
    void addOrUpdateProduct(Product dto);
    Optional<Product> getById(Long id);
    void remove(Long id);
}
