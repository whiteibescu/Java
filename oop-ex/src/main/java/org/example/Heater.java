package org.example;

public class Heater extends Device implements ILinearValue, IOnOff {
    private int linearValue = 0;

    Heater(String name) {
        super(name);
        type = "heater";
    }

    @Override
    public void showStatus() {
        System.out.println("Heat is " + linearValue);
    }

    @Override
    public int getLinearValue() {
        return linearValue;
    }

    @Override
    public void setLinearValue(int val) {
        if (val < 200 && val >= 0) {
            this.linearValue = val;
        }
    }

    @Override
    public boolean getIsOn() {
        return linearValue > 0;
    }

    @Override
    public void on() {
        linearValue = 10;
    }

    @Override
    public void off() {
        linearValue = 0;
    }
}
