package com.ecorn.webshop.service;

import com.ecorn.webshop.entity.Order;

public interface OrderService {
    void saveOrder(Order order);

    Order getOrder(Long id);
}
