package com.ecorn.webshop.controllers;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Category;
import com.ecorn.webshop.entity.Image;
import com.ecorn.webshop.entity.Product;
import com.ecorn.webshop.service.CategoryService;
import com.ecorn.webshop.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import com.ecorn.webshop.service.SessionObjectHolder;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final SessionObjectHolder sessionObjectHolder;

    public ProductController(ProductService productService, CategoryService categoryService, SessionObjectHolder sessionObjectHolder) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.sessionObjectHolder = sessionObjectHolder;
    }

    @GetMapping("/products")
    public String list(Model model) {
        List<ProductDTO> list = productService.getAll();
        model.addAttribute("product", list);
        return "products";
    }

    @GetMapping("/products/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        sessionObjectHolder.addClick();
        if(principal == null){
            return "redirect:/products";
        }
        productService.addToUserBucket(id, principal.getName());
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        productService.remove(id);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable(name = "id") Long id, Model model) {
        ProductDTO product = productService.getById(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @PostMapping("/products/save")
    public String addProduct(@ModelAttribute("product") ProductDTO product,
                             HttpServletRequest request) {
        List<Image> image = new ArrayList<>();
        image.setTitle(request.getParameter("title"));
        image.setUrl(request.getParameter("image1"));

        productService.addOrUpdateProduct(product, image);
        return "redirect:/products";
    }

    @GetMapping("/products/new_product")
    public String addProductForProductList(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @GetMapping("/products/{id}")
    public ProductDTO getById(@PathVariable Long id){
        return productService.getById(id);
    }
}
