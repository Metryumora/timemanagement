package edu.chdtu.timemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class TimeManagementApplication {


    public static void main(String[] args) {
        SpringApplication.run(TimeManagementApplication.class, args);
    }


    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TimeManagementApplication.class);
    }


}
