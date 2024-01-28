package com.ecorn.webshop.service;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Image;
import com.ecorn.webshop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAll();
    void addToUserBucket(Long productId, String username);
    void addOrUpdateProduct(ProductDTO dto);
    ProductDTO getById(Long id);
    void remove(Long id);
}
