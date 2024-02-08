package com.ecorn.webshop.service;

import com.ecorn.webshop.convertations.MultipartFileToImageConverter;
import com.ecorn.webshop.dao.ProductRepository;
import com.ecorn.webshop.entity.*;
import com.ecorn.webshop.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductMapper mapper = ProductMapper.MAPPER;

    private final ProductRepository productRepository;
    private final UserService userService;
    private final BucketService bucketService;
    private final ProductSizeService productSizeService;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, BucketService bucketService, ProductSizeService productSizeService) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.bucketService = bucketService;
        this.productSizeService = productSizeService;
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
    public void addOrUpdateProduct(Product product, MultipartFile file1,
                                   MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if(file1.getSize() != 0){
            image1 = new MultipartFileToImageConverter().convert(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if(file2.getSize() != 0){
            image2 = new MultipartFileToImageConverter().convert(file2);
            product.addImageToProduct(image2);
        }
        if(file3.getSize() != 0){
            image3 = new MultipartFileToImageConverter().convert(file3);
            product.addImageToProduct(image3);
        }
        log.info("Saving new Product {};", product.getTitle());

        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
    }

    @Override
    @Transactional
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<ProductSize> saveSizes(List<Long> sizes){
        return productSizeService.getAllProductSizesById(sizes);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}