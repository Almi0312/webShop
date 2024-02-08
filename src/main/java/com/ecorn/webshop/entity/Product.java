package com.ecorn.webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.engine.jdbc.Size;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    private static final String SEQ_NAME = "product_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,
             allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    @CreationTimestamp
    private LocalDateTime dateOfCreated;
    @UpdateTimestamp
    private LocalDateTime dateOfChange;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
    mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category categories;
    @ManyToMany
    @JoinTable(name="products_sizes",
            joinColumns = @JoinColumn(name = "size_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductSize> sizes = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductComment> comments;

    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }

    public void addImageToProduct(Image image){
        image.setProduct(this);
        images.add(image);
    }
}
