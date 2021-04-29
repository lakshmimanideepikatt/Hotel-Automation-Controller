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


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicEquipment that = (ElectronicEquipment) o;
        return getUnits() == that.getUnits() &&
                isOn() == that.isOn() &&
                getType().equals(that.getType());
    }
    public int hashCode() {
        return Objects.hash(getType(), getUnits(), isOn());
    }
}