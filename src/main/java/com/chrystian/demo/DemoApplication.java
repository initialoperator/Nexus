package com.chrystian.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
//        (scanBasePackages={
//        "com.chrystian.entity", "com.chrystian.service","com.chrystian.repository", "com.chrystian.configuration"})
@ComponentScan(basePackages = "com.chrystian")
@EntityScan("com.chrystian.entity")
@EnableJpaRepositories("com.chrystian.repository")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
