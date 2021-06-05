package org.stol.vaadinintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VaadinIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaadinIntroApplication.class, args);
    }

}
