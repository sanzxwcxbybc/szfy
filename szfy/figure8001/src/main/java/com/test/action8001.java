package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.mapper","com.test.service","com.test.controller","com.test.interceptor","com.test.config"})
public class action8001 {
    public static void main(String[] args) {
        SpringApplication.run(action8001.class,args);
    }
}
