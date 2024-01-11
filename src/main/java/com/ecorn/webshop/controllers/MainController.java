package com.ecorn.webshop.controllers;

import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.dto.UserDTO;
import com.ecorn.webshop.service.SessionObjectHolder;
import com.ecorn.webshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * Главная страница, которая открывается при входе на сайт
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login-error") //гость попал на 404 page
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("users") UserDTO dto){
        userService.save(dto);
        return "/login";
    }
}
