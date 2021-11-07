package com.pluralsight.conferencedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ConferenceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceDemoApplication.class, args);
    }

}
