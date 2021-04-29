package com.Junit.hms.electronics;

import com.Junit.hms.sensors.*;

import com.Junit.hms.hotel.*;
import java.util.*;

public class Factory {

    private Collection<Hotel>   hotels;
    private MotionController motionController;
    NightShift th[];
    public Factory(Collection<Hotel> hotels, MotionController motionController) {
        this.hotels = hotels;
        this.motionController = motionController;
    }
    public void nightShiftStart(){
    	
    	int i=0;
    	th=new NightShift[hotels.size()];
    	for(Hotel hotel:hotels) {
    		th[i]=new NightShift(hotel,motionController);
    		th[i].start();
    		i++;
    	}
    }
    @SuppressWarnings("deprecation")
	public void nightShiftEnd() {
    	for(NightShift temp:th) {
    		temp.destroy();
    	}
    }
    

}
class NightShift extends Thread{
	Hotel hotel;
	MotionController motionController;
	NightShift(Hotel hotel,MotionController motionController){
		this.hotel=hotel;
		this.motionController=motionController;
	}
	public void run() {
		while(true) {
		for(Floor floor:hotel.getFloors()) {
    		for(SubCorridor sub:floor.getSubCorridors()) {
    			if(motionController.isMovement()){
    				ElectronicEquipment tempL=sub.electronicEquipmentMap.get("Light");
    				ElectronicEquipment tempAc=sub.electronicEquipmentMap.get("AC");
    				tempL.on=true;
    				sub.electronicEquipmentMap.put("Light",tempL);
    				if(floor.totalPowerConsumption()>=(floor.getCorridors().size()*15+floor.getSubCorridors().size()*10)) {
    					tempAc.on=false;
    				}
    				sub.electronicEquipmentMap.put("AC",tempAc);
    			}
    			if(motionController.noMovementInAMinute()){
    				ElectronicEquipment tempL=sub.electronicEquipmentMap.get("Light");
    				ElectronicEquipment tempAc=sub.electronicEquipmentMap.get("AC");
    				tempL.on=false;
    				sub.electronicEquipmentMap.put("Light",tempL);
    				if(floor.totalPowerConsumption()<=(floor.getCorridors().size()*15+floor.getSubCorridors().size()*10)) {
    					tempAc.on=true;
    				}
    				sub.electronicEquipmentMap.put("AC",tempAc);
    			}
    		}
		}
		
	}
}
}