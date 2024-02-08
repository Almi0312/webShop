package com.ecorn.webshop.service;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Image;
import com.ecorn.webshop.entity.Product;
import com.ecorn.webshop.entity.ProductSize;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    List<Product> getAll();
    void addToUserBucket(Long productId, String username);
    void addOrUpdateProduct(Product product, MultipartFile image1,
                            MultipartFile image2, MultipartFile image3) throws IOException;
    Product getById(Long id);
    void remove(Long id);
    List<ProductSize> saveSizes(List<Long> sizes);
    void save(Product product);
}
