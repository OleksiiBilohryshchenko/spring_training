package com.example.bean_annotation;

import com.example.bean_annotation.casefactory.Case;
import com.example.bean_annotation.config.ComputerConfig;
import com.example.bean_annotation.config.RandomConfig;
import com.example.bean_annotation.monitorfactory.Monitor;
import com.example.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        Monitor theMonitor = container.getBean(Monitor.class);
        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);

        PC myPC = new PC(theCase,theMonitor,theMotherboard);

        myPC.powerUp();

    }

}
