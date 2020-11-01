package com.yinsy.onepiece;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class OnePieceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnePieceApplication.class, args);
    }

}
