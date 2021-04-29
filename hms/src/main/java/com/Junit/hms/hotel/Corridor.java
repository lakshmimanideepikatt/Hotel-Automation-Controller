package com.Junit.hms.hotel;

import com.Junit.hms.electronics.*;
import com.Junit.hms.sensors.*;
import java.util.*;


public class Corridor implements MotionSensor {

    public Map<String, ElectronicEquipment> electronicEquipmentMap;

    public Corridor(Collection<ElectronicEquipment> equipments) {
    	electronicEquipmentMap=new HashMap<String,ElectronicEquipment>();
        for(ElectronicEquipment temp:equipments) {
        	electronicEquipmentMap.put(temp.getType(), temp);
        }
    }

    public ElectronicEquipment getElectronicEquipment(String name) {
        return electronicEquipmentMap.get(name);
    }

    int getTotalPowerConsumption() {
    	int totalPower=0;
        for(ElectronicEquipment temp:electronicEquipmentMap.values()) {
        	totalPower+=temp.getUnits();
        }
        return totalPower;
    }
}