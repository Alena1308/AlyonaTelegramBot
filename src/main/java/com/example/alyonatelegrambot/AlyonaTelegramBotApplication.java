package com.example.alyonatelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AlyonaTelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlyonaTelegramBotApplication.class, args);
    }

}
