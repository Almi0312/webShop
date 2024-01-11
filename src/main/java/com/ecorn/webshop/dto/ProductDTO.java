package com.ecorn.webshop.dto;

import com.ecorn.webshop.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private byte[] image;
    private Category category;
}
