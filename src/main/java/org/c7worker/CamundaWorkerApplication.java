package org.c7worker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CamundaWorkerApplication{

//    Spring Boot Anwendung zur Registrierung und Abarbeitung der Worker

    public static void main(String[] args) {
        SpringApplication.run(CamundaWorkerApplication.class, args).close();
    }
}