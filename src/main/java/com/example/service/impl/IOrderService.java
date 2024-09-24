package com.example.service.impl;

import com.example.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    Order save(Order order);
    void deleteById(Long id);
}
