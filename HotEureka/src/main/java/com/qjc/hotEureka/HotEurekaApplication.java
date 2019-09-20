package com.qjc.hotEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotEurekaApplication.class, args);
    }

}
