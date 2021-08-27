package net.company.controller;

import net.company.model.Model;

public class Controller {
    private Model model;

    public Controller(Model model){
        this.model = model;
    }

    public boolean checkPin(int pin) {
        return model.getPin() == pin;
    }
}
