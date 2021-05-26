class Device {
    String name;

    Device(String name) {

    }

    public String getType() {
        return "just device";
    }
}

class KeyBoard extends Device {
    private boolean isPressed;


    KeyBoard(String name) {
        super(name);
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void Pressed() {
        isPressed = true;
    }

    public void NotPressed() {
        isPressed = false;
    }
}

class Switch extends Device {

    private boolean isOn;


    Switch(String name) {
        super(name);
    }

    public boolean isOn() {
        return isOn;
    }

    public void On() {
        isOn = true;

    }

    public void Off() {
        isOn = false;
    }

    public String getType() {
        return "switch";
    }
}


class Blub extends Device {
    private boolean isOn;

    Blub(String name) {
        super(name);
    }

    public boolean isOn() {
        return isOn;

    }

    public void On() {
        isOn = true;
    }

    public void Off() {
        isOn = false;
    }

    public String getType() {
        return "blub";
    }

}


public class Main {

    static public void main(String[] args) {
        Device device = new Device("dev1");
        Blub blub = new Blub("light1");
        Blub blub2 = new Blub("light2");
        Switch switch1 = new Switch("switch1");
        Device[] devices = new Device[]
                {
                        device,
                        blub,
                        blub2,
                        switch1
                };

        for (int i = 0; i < devices.length; ++i) {
            System.out.println(devices[i].getType());
        }
    }
}
