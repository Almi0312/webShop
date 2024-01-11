package com.ecorn.webshop.controllers;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Category;
import com.ecorn.webshop.service.CategoryService;
import com.ecorn.webshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import com.ecorn.webshop.service.SessionObjectHolder;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final SessionObjectHolder sessionObjectHolder;

    public ProductController(ProductService productService, CategoryService categoryService, SessionObjectHolder sessionObjectHolder) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.sessionObjectHolder = sessionObjectHolder;
    }

    @GetMapping
    public String list(Model model) {
        List<ProductDTO> list = productService.getAll();
        model.addAttribute("products", list);
        return "products";
    }

    @GetMapping("/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        sessionObjectHolder.addClick();
        if(principal == null){
            return "redirect:/products";
        }
        productService.addToUserBucket(id, principal.getName());
        return "redirect:/products";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Void> addProduct(@ModelAttribute("product") ProductDTO dto){
        productService.addProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PreAuthorize("hasAuthority({'ADMIN','MANAGER'})")
    @GetMapping("/new_product")
    public String addProductForProductList(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductDTO());
        return "new_product";
    }

    @MessageMapping("/products")
    public void messageAddProduct(ProductDTO dto){
        productService.addProduct(dto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ProductDTO getById(@PathVariable Long id){
        return productService.getById(id);
    }

}
