package com.Junit.hms.electronics;

import java.util.*;

public class ElectronicBuilder{

    public static final String LIGHT = "Light";
    public static final String AC = "Ac";

    public static Collection<ElectronicEquipment> getSubCorridorDevices() {
        return Arrays.asList(new ElectronicEquipment(LIGHT, 5, false),
                new ElectronicEquipment(AC, 10, true));
    }

    public static Collection<ElectronicEquipment> getCorridorDevices() {
        return Arrays.asList(new ElectronicEquipment(LIGHT, 5, true),
                new ElectronicEquipment(AC, 10, true));
    }
}