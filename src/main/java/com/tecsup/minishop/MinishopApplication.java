package com.tecsup.minishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Configura la aplicación y detecta los componentes de sus subcarpetas.
@SpringBootApplication
public class MinishopApplication {

    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot.
        SpringApplication.run(MinishopApplication.class, args);
    }
}