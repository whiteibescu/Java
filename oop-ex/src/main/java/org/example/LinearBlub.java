package org.example;

public class LinearBlub extends Blub implements ILinearValue {
    private int linearValue = 0;

    LinearBlub(String name) {
        super(name);
    }

    public int getLinearValue() {
        return linearValue;
    }

    public void setLinearValue(int val) {
        if (val < 100 && val >= 0) {
            this.linearValue = val;
        }
    }
}
