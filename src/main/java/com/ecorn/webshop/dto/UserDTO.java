package com.ecorn.webshop.dto;

import com.ecorn.webshop.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String password;
    private String matchingPassword;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Role role;
}
