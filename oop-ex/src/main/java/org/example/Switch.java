package org.example;

public class Switch extends Device implements IOnOff {
    private boolean isOn = false;

    Switch(String name) {
        super(name);
        type = "switch";
    }

    @Override
    public void showStatus() {
        System.out.println("switch is " + (isOn ? "On" : "Off"));
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
