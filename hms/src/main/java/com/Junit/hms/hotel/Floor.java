package com.Junit.hms.hotel;

import com.Junit.hms.electronics.*;

import java.util.*;

public class Floor {
    private final List<Corridor> corridors;
    private final List<SubCorridor> subCorridors;

    public Floor(int numberOfMainCorridors, int numberOfSubCorridors) {
        corridors = new ArrayList<Corridor>();
        for(int corridorIndex=0;corridorIndex<numberOfMainCorridors;corridorIndex++) {
            corridors.add(new Corridor(ElectronicBuilder.getCorridorDevices()));
        }
        subCorridors = new ArrayList<SubCorridor>();
        for(int subCorridorIndex=0; subCorridorIndex<numberOfSubCorridors;subCorridorIndex++) {
            subCorridors.add(new SubCorridor(ElectronicBuilder.getSubCorridorDevices()));
        }
    }

    public List<Corridor> getCorridors() {
        return corridors;
    }

    public List<SubCorridor> getSubCorridors() {
        return subCorridors;
    }

    public int totalPowerConsumption() {
      
        int totalPower=0;
        for(Corridor temp:corridors) {
        	totalPower+=temp.getTotalPowerConsumption();
        }
        for(SubCorridor temp:subCorridors) {
        	totalPower+=temp.getTotalPowerConsumption();
        }
        return totalPower;
        
    }

}