package com.example.serverresigster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerResigsterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerResigsterApplication.class, args);
    }

}
