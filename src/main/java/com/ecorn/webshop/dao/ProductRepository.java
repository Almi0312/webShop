package com.ecorn.webshop.dao;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
