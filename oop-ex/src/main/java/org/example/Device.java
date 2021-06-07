package org.example;

public abstract class Device {
    protected String name;
    protected String type;

    Device(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract void showStatus();

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
