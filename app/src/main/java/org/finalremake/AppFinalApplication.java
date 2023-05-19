package org.finalremake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This scanBasePackages annotation is used for repositories.
@SpringBootApplication(scanBasePackages = "org.finalremake.data.model")

// NECESSARY IF DATA IS IN PACKAGE DIFFERENT FROM ORG.FINALREMAKE in this case.
//@EntityScan(basePackages = "org.finalremake.data.model")
public class AppFinalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppFinalApplication.class, args);
    }
}
