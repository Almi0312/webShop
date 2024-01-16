package com.ecorn.webshop.service;

import com.ecorn.webshop.dao.ProductRepository;
import com.ecorn.webshop.entity.Bucket;
import com.ecorn.webshop.entity.Product;
import com.ecorn.webshop.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;
    private final BucketService bucketService;

    public ProductServiceImpl(ProductRepository productRepository,
                              UserService userService,
                              BucketService bucketService
    ) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.bucketService = bucketService;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void addToUserBucket(Long productId, String username) {
        User user = userService.findByName(username);
        if (user == null) {
            throw new RuntimeException("User not found. " + username);
        }

        Bucket bucket = user.getBucket();
        if (bucket == null) {
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(productId));
            user.setBucket(newBucket);
            userService.save(user);
        } else {
            bucketService.addProducts(bucket, Collections.singletonList(productId));
        }
    }

    @Override
    @Transactional
    public void addOrUpdateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        productRepository.deleteById(id);
    }
}
