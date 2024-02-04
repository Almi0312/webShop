package com.ecorn.webshop.service;

import com.ecorn.webshop.entity.ProductSize;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductSizeService {
    List<ProductSize> getAll();
    Optional<ProductSize> getProductSize(Long id);
    List<ProductSize> getAllProductSizesById(List<Long> sizes);
}
