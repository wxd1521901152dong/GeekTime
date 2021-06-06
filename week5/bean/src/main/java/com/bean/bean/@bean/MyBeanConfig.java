package com.example.code.class9.javacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lw
 */
@Configuration
public class MyBeanConfig {

    @Bean
    public com.example.code.class9.javacode.MyBeanExample javaCodeExample() {
        return new com.example.code.class9.javacode.MyBeanExample();
    }
}
