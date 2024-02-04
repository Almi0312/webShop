package com.ecorn.webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_sizes")
public class ProductSize {
    private static final String SEQ_NAME = "product_sizes_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,
            allocationSize = 1)
    private Long id;
    @Column(name = "ru_size")
    private String ruSize;
    @Column(name = "inter_size")
    private String interSize;
    @ManyToMany(mappedBy = "sizes")
    private List<Product> product;
}
