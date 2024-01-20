package com.ecorn.webshop.service;

import com.ecorn.webshop.entity.Image;
import com.ecorn.webshop.entity.Product;

import java.util.List;

public interface ImageService {
    void addMultiFile(Image image);
    Image getId(Long id);
    void delete(Long id);

}
