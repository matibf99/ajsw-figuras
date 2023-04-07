package com.example.shapesapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShapesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShapesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //OrderShapes.main(null);
        CreateAndPrintShapes.main(null);
    }
}
