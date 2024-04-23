package com.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.erp"})
@MapperScan("com.xll.erp.dao")
@EnableWebMvc
public class App {

    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}
