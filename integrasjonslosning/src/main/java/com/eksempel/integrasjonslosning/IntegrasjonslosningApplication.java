package com.eksempel.integrasjonslosning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IntegrasjonslosningApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
       // SpringApplication.run(IntegrasjonslosningApplication.class, args);
        new IntegrasjonslosningApplication()
                .configure(new SpringApplicationBuilder(IntegrasjonslosningApplication.class))
                .run(args);
    }

}
