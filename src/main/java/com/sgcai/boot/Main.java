package com.sgcai.boot;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
