package org.example;

public class Blub extends Device implements IOnOff {
    private boolean isOn = false;

    Blub(String name) {
        super(name);
        type = "blub";
    }

    @Override
    public void showStatus() {
        System.out.print("Blub (" + name + ") is ");
        System.out.println(isOn ? "On" : "Off");
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void on() {
        isOn = true;
    }

    public void off() {
        isOn = false;
    }
}
