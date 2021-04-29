package com.Junit.hms.electronics;

import java.util.Objects;

public class ElectronicEquipment {
    public String type;
    public int units;
    public boolean on;

    public ElectronicEquipment(String type, int units, boolean on) {
        this.type = type;
        this.units = units;
        this.on = on;
    }

    public int getUnits() {
        return on ? units : 0;
    }

    void switchIt(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public boolean isOff() {
        return !on;
    }

    public String getType() {
        return type;
    }


   
}
