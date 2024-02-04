package com.ecorn.webshop.service;

import com.ecorn.webshop.dao.ProductSizeRepository;
import com.ecorn.webshop.entity.Product;
import com.ecorn.webshop.entity.ProductSize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductSizeServiceImpl implements ProductSizeService {
    private final ProductSizeRepository productSizeRepository;

    public ProductSizeServiceImpl(ProductSizeRepository productSizeRepository) {
        this.productSizeRepository = productSizeRepository;
    }

    @Override
    public List<ProductSize> getAll() {
        return productSizeRepository.findAll();
    }

    @Override
    public Optional<ProductSize> getProductSize(Long id) {
        return productSizeRepository.findById(id);
    }

    @Override
    public List<ProductSize> getAllProductSizesById(List<Long> sizes) {
        return productSizeRepository.findAllById(sizes);
    }
}
