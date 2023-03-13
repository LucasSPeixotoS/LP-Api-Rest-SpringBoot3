package com.restapi.lp.services;

import com.restapi.lp.entities.Order;
import com.restapi.lp.entities.User;
import com.restapi.lp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            return new Order();
        } else {
            return order.get();
        }

    }
}
