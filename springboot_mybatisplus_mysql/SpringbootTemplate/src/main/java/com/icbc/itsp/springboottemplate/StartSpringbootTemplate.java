package com.icbc.itsp.springboottemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 */
@SpringBootApplication
@MapperScan("com.icbc.itsp.springboottemplate.mapper")
public class StartSpringbootTemplate {
    public static void main( String[] args ) {
        SpringApplication.run(StartSpringbootTemplate.class, args);
    }
}
