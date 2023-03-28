package com.alongchan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Payment8002Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002Main.class,args);
    }
}