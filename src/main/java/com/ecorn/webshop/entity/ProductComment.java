package com.ecorn.webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_comments")
public class ProductComment {
    private static final String SEQ_NAME = "product_comment_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,
            allocationSize = 1)
    private Long id;
    @ManyToOne()
    private User user;

    private String description;
    @ManyToOne()
    private Product product;
    @CreationTimestamp
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @PrePersist
    private void init(){
        dateCreated = LocalDateTime.now();
    }
}

