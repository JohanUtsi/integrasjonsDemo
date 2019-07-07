package com.eksempel.fagsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FagsystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //SpringApplication.run(FagsystemApplication.class, args);
        new FagsystemApplication()
                .configure(new SpringApplicationBuilder(FagsystemApplication.class))
                .run(args);
    }

}
