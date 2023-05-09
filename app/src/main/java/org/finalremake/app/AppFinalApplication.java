package org.finalremake.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.finalremake")
public class AppFinalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppFinalApplication.class, args);
    }
}
