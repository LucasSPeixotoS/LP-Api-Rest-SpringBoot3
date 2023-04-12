package com.restapi.lp.repositories;

import com.restapi.lp.entities.OrderItem;
import com.restapi.lp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
