package com.ecorn.webshop.service;

import com.ecorn.webshop.dao.ImageRepository;
import com.ecorn.webshop.entity.Image;
import com.ecorn.webshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImp implements ImageService{
    ImageRepository imageRepository;

    public ImageServiceImp(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void addMultiFile(Image image) {
        if (image != null) {
            imageRepository.save(image);
        }
    }

    @Override
    public Image getId(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        return image.orElseThrow(() -> new IllegalArgumentException("Такого изображения нет"));
    }

    @Override
    public void delete(Long id) {

    }
}
