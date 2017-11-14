package com.qianjh.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author QianJH
 */
@SpringCloudApplication
public class ServiceSequence {
    public static void main(String... args) {
        SpringApplication.run(ServiceSequence.class, args);
    }
}
