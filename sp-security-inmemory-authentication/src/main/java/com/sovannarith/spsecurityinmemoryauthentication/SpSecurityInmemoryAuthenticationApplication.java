package com.sovannarith.spsecurityinmemoryauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// enable if you want to use Spring XML Configuration
// @ImportResource("classpath:spring-security-config.xml")
public class SpSecurityInmemoryAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpSecurityInmemoryAuthenticationApplication.class, args);
    }
}
