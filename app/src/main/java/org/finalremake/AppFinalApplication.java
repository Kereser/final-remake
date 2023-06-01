package org.finalremake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Enable scanBasePackages = "org.finalremake.data.repository" si da fallos con los repos.
@SpringBootApplication()

// NECESSARY IF DATA IS IN PACKAGE DIFFERENT FROM ORG.FINALREMAKE in this case.
// If entities on org.finalremake.data and main application on org.finalremake.finalapp
// bc application will scan entities only under org.finalremake.finalapp and below.
//@EntityScan(basePackages = "org.finalremake.data.model")
public class AppFinalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppFinalApplication.class, args);
    }
}
