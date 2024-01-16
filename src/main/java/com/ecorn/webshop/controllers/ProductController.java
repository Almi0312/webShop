package com.ecorn.webshop.controllers;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Category;
import com.ecorn.webshop.entity.Product;
import com.ecorn.webshop.service.CategoryService;
import com.ecorn.webshop.service.ProductService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import com.ecorn.webshop.service.SessionObjectHolder;

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
        List<Product> list = productService.getAll();
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
    public String updateProduct(@PathVariable(name = "id") Long id, Model model) throws ChangeSetPersister.NotFoundException {
        model.addAttribute("product", productService.getById(id).orElseThrow(ChangeSetPersister.NotFoundException :: new));
        return "new_product";
    }

    @PostMapping("/products/save")
    public String addProduct(@ModelAttribute("product") Product product){
        productService.addOrUpdateProduct(product);
        return "redirect:/products";
    }

//    @PreAuthorize("hasAuthority({'ADMIN','MANAGER'})")
    @GetMapping("/products/new_product")
    public String addProductForProductList(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return productService.getById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
