package com.example.bean_annotation.config;

import com.example.bean_annotation.casefactory.Case;
import com.example.bean_annotation.casefactory.DellCase;
import com.example.bean_annotation.monitorfactory.Monitor;
import com.example.bean_annotation.monitorfactory.SonyMonitor;
import com.example.bean_annotation.motherboardfactory.AsusMotherboard;
import com.example.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {
    @Bean
    public Monitor monitorSony(){
        return new SonyMonitor("25 inch Beast","Sony",25);
    }
    @Bean
    public Case caseDell (){
        return new DellCase("220volt", "Dell", "220");
    }
    @Bean
    public Motherboard motherboardAsus(){
        return new AsusMotherboard("BJ-200","Asus",4,6,"v2.44");
    }

}
