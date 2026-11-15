package com.example.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SupportTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupportTicketApplication.class, args);
    }
}
