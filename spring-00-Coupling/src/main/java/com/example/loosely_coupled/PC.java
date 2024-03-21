package com.example.loosely_coupled;

import com.example.loosely_coupled.casefactory.Case;
import com.example.loosely_coupled.monitorfactory.Monitor;
import com.example.loosely_coupled.motherboardfactory.Motherboard;

public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

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
        monitor.drawPixelAt();
    }
}

