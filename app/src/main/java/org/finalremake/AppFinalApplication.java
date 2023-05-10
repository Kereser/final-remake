package org.finalremake;

import org.finalremake.data.model.Address;
import org.finalremake.data.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// NECESSARY IF DATA IS IN PACKAGE DIFFERENT THAN ORG.FINALREMAKE
//@EntityScan(basePackages = "org.finalremake.data.model")
public class AppFinalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppFinalApplication.class, args);
    }

    public static Address getAddress() {
        return new Address();
    }

    public static Product getProduct(String productName) {
        return new Product();
    }
}
