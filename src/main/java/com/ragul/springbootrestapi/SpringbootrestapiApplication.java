package com.ragul.springbootrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootrestapiApplication.class, args);
    }
}
