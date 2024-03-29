package com.ecorn.webshop.dto;

import com.ecorn.webshop.entity.Category;
import com.ecorn.webshop.entity.Image;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private List<Image> images;
    private Category category;
}