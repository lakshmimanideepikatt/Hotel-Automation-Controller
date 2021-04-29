package com.Junit.hms.hotel;

import java.util.*;

public class Hotel{

    private List<Floor> floors;

    public Hotel(int numberOfFloors, int numberOfMainCorridors, int numberOfSubCorridors) {
        floors = new ArrayList<Floor>();
        for(int floorIndex=0;floorIndex<numberOfFloors;floorIndex++) {
            floors.add(new Floor(numberOfMainCorridors, numberOfSubCorridors));
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }
}