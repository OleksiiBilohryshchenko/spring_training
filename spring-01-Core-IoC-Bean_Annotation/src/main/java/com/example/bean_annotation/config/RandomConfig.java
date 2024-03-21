package com.example.bean_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomConfig {
    @Bean
    public String myString(){
        return "Example";
    }
    @Bean
    public Integer myInteger(){
        return 7;
    }

}
