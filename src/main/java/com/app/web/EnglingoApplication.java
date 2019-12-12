package com.app.web;

import com.app.web.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EnglingoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnglingoApplication.class, args);
    }

}
