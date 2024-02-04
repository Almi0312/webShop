package com.ecorn.webshop.dao;

import com.ecorn.webshop.entity.ProductSize;
import org.hibernate.engine.jdbc.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
}
