package com.ecorn.webshop.service;

import com.ecorn.webshop.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();
    Optional<Category> getCategory(long id);
}
