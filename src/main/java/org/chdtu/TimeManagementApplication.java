package org.chdtu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableAutoConfiguration
@SpringBootApplication
public class TimeManagementApplication {


    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TimeManagementApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TimeManagementApplication.class, args);
    }
}
