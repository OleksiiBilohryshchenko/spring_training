package com.example.stereotype_annotation;


import com.example.stereotype_annotation.casefactory.Case;
import com.example.stereotype_annotation.monitorfactory.Monitor;
import com.example.stereotype_annotation.motherboardfactory.Motherboard;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PC {


    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    @Autowired // constructor injection, but it is not needed if only 1 constructor or just use @AllArgsConstructor
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}

