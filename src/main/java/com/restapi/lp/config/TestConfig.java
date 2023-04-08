package com.restapi.lp.config;

import com.restapi.lp.entities.Category;
import com.restapi.lp.entities.Order;
import com.restapi.lp.entities.Product;
import com.restapi.lp.entities.User;
import com.restapi.lp.entities.enums.OrderStatus;
import com.restapi.lp.repositories.CategoryRepository;
import com.restapi.lp.repositories.OrderRepository;
import com.restapi.lp.repositories.ProductRepository;
import com.restapi.lp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(
                null, "Lucas Peixoto", "lucasxvs5@gmail.com", "11999999999", "1234"
        );
        User user2 = new User(
                null, "Eleonora Mezan", "teste@gmail.com", "11999999999", "1234"
        );

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, OrderStatus.DELIVERED, LocalDate.now(), user1);
        Order order2 = new Order(null, OrderStatus.PAID, LocalDate.now(), user2);
        Order order3 = new Order(null, OrderStatus.WAITING_PAYMENT, LocalDate.now(), user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        Category category1 = new Category(null, "Computers");
        Category category2 = new Category(null, "Smartphones");
        Category category3 = new Category(null, "Tablets");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

    }
}
