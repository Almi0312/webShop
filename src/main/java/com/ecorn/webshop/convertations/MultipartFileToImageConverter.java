package com.ecorn.webshop.convertations;

import com.ecorn.webshop.entity.Image;
import com.ecorn.webshop.entity.Product;
import com.ecorn.webshop.service.ProductService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MultipartFileToImageConverter implements Converter<MultipartFile, Image> {

    @Override
    public Image convert(MultipartFile file) {
                byte[] imageData = new byte[0];
                try {
                    imageData = file.getBytes();
                } catch (IOException e) {
                e.printStackTrace();
                }

                Image image = new Image();
                image.setTitle(file.getOriginalFilename());
                image.setData(imageData);
        return image;
    }
}
