package com.talch.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SmallRestForReactExApplication {

    public static void main(String[] args) {

        SpringApplication.run(SmallRestForReactExApplication.class, args);
        System.out.println("START!!!!!!!!!!!!!!!!");

    }

}
