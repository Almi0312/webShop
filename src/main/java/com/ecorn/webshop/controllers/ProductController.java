package com.ecorn.webshop.controllers;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Category;
import com.ecorn.webshop.entity.Image;
import com.ecorn.webshop.entity.Product;
import com.ecorn.webshop.entity.ProductSize;
import com.ecorn.webshop.service.CategoryService;
import com.ecorn.webshop.service.ProductService;
import com.ecorn.webshop.service.ProductSizeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ecorn.webshop.service.SessionObjectHolder;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductSizeService productSizeService;

    public ProductController(ProductService productService, CategoryService categoryService, ProductSizeService productSizeService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.productSizeService = productSizeService;
    }

    @GetMapping("/products")
    public String list(Model model) {
        List<Product> list = productService.getAll();
        model.addAttribute("products", list);
        return "products";
    }

    @GetMapping("/products/product/{id}")
    public String productInfo(@PathVariable(name = "id") Long id, Model model){
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product_card";
    }

    @GetMapping("/products/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        if(principal == null){
            return "redirect:/products";
        }
        productService.addToUserBucket(id, principal.getName());
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable(name = "id") Long id, Model model) {
        Product product = productService.getById(id);
        List<Image> images = product.getImages();
        List<Category> categories = categoryService.getAll();
        List<ProductSize> productSizes = productSizeService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        model.addAttribute("images", images);
        model.addAttribute("product_sizes",productSizes);
        return "edit_product";
    }

    @PostMapping("/products/save")
    public String addProduct(@ModelAttribute("product") Product product,
                             @RequestParam("file1") MultipartFile image1,
                             @RequestParam("file2") MultipartFile image2,
                             @RequestParam("file3") MultipartFile image3,
                             @RequestParam("product_sizes") List<Long> productSized) {
        try {
            productService.addOrUpdateProduct(product, image1, image2, image3);
        }catch (IOException e){
            e.printStackTrace();
        }
        product.setSizes(productSizeService.getAllProductSizesById(productSized));
        return "redirect:/products";
    }

    @GetMapping("/products/new_product")
    public String addProductForProductList(Model model){
        List<Category> categories = categoryService.getAll();
        List<ProductSize> productSizes = productSizeService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product_sizes", productSizes);
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        productService.remove(id);
        return "redirect:/products";
    }
}
