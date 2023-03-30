package com.alongchan;

import com.sun.org.apache.xerces.internal.dom.PSVIDocumentImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004Main.class,args);
    }
}