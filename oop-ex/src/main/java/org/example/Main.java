package org.example;

//  Device  : abstract
//  Blub, Switch

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static public void main(String[] args) {

//        Device device = new Device("dev1"); ERROR!!! abstract
//        Blub blub = new Blub("light1");
//        Blub blub2 = new Blub("light2");
//        Switch switch1 = new Switch("switch1");
//        Device switch2 = new Switch("switch2");

//        Device[] devices = new Device[]{
//                new Blub("light1"),
//                new LinearBlub("light2"),
//                new Heater("room1 heater"),
//                new Switch("switch1"),
//                new Switch("switch2"),
//        };
        LinkedList devices = new LinkedList<Device>();
        devices.add(new Blub("light1"));
        devices.add(new Blub("light2"));
        Heater heater = new Heater("heater");
        devices.add(heater);
        devices.remove(1);
        devices.remove(heater);


//        ILinearValue lv1 = new LinearBlub("lb1");
//        ILinearValue lv2 = new Heater("ht1");
//
//        for (Device dev : devices) {
//            dev.showStatus();
//            if (dev instanceof ILinearValue) {
//                ILinearValue lv = (ILinearValue) dev;
//                lv.setLinearValue(10);
//            }
//            if (dev instanceof Switch) {
//                Switch lv = (Switch) dev;
//                lv.on();
//            }
//            // show status
//        }
//
//        for (Device dev : devices) {
//            dev.showStatus();
//        }

//        for (int i = 0; i < devices.length; i++) {
//            System.out.println(devices[i]);
//        }


        // Blub acualyDevice = device; ERROR!!!

//        System.out.println(device.getType());
//        System.out.println(blub.getType());
//        System.out.println(blub.getIsOn());
//        blub.on();
//        System.out.println(blub.getIsOn());
        System.out.println();
//        System.out.println(blub instanceof Blub);
//        System.out.println(blub instanceof Device);
//        System.out.println(device instanceof Blub);
//        System.out.println(device instanceof Object);


    }
}
