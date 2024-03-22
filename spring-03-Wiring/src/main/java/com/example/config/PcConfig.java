package com.example.config;

import com.example.casefactory.Case;
import com.example.casefactory.DellCase;
import com.example.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {
    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    }
    @Bean
    public Case caseDell(Dimensions dimensions){

        return new DellCase("220B","Dell","240",dimensions);
    }

}
