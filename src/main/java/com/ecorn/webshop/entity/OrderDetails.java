package com.ecorn.webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_details")
public class OrderDetails {
    private static final String SEQ_NAME = "order_details_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,
     allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Long amount;
    private BigDecimal price;

    public OrderDetails(Order order, Product product, Long amount) {
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.price = product.getPrice();
    }
}