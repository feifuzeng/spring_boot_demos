package com.ohaotian.feifz.style;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages={ "com.ohaotian.feifz.style"})
public class StyleBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StyleBootApplication.class, args);
    }

}

