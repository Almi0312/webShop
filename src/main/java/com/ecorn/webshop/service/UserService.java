package com.ecorn.webshop.service;

import com.ecorn.webshop.dto.UserDTO;
import com.ecorn.webshop.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Для безопасности с авторизацией
 */
public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);
    void save(User user);
    List<UserDTO> getAll();
    User findByName(String name);
    void updateProfile(UserDTO dto);
}
