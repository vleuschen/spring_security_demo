package com.vae;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author vleus
 * @date 2022年07月28日 22:44
 */
@SpringBootApplication
@MapperScan(basePackages = "com.vae.mapper")
public class TokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenApplication.class);
    }
}