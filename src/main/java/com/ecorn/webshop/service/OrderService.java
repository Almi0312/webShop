package com.ecorn.webshop.service;

import com.ecorn.webshop.entity.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    List<Order> findAll();
    Order getOrder(Long id);
}
