package com.ecorn.webshop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    private static final String SEQ_NAME = "user_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,
            allocationSize = 1)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime created = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Role role;
    private String address;
    private boolean archive;
    private String phone;
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Bucket bucket;
}
