package com.ecorn.webshop.convertations;

import com.ecorn.webshop.entity.Image;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Component
public class MultipartFileToImageConverter implements Converter<MultipartFile, Image> {

    @Override
    public Image convert(MultipartFile file) {
        Image image = new Image();
        image.setTitle(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        try {
            image.setBytes(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }
}
