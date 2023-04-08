package com.restapi.lp.repositories;

import com.restapi.lp.entities.Category;
import com.restapi.lp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
