package com.restapi.lp.config;

import com.restapi.lp.entities.Order;
import com.restapi.lp.entities.User;
import com.restapi.lp.repositories.OrderRepository;
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

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(
                null, "Lucas Peixoto", "lucasxvs5@gmail.com", "11999999999", "1234"
        );
        User user2 = new User(
                null, "Eleonora Mezan", "teste@gmail.com", "11999999999", "1234"
        );

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, LocalDate.now(), user1);
        Order order2 = new Order(null, LocalDate.now(), user2);
        Order order3 = new Order(null, LocalDate.now(), user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
