package com.Junit.hms.factory;
import com.Junit.hms.electronics.ElectronicEquipment;
import com.Junit.hms.hotel.Floor;
import com.Junit.hms.hotel.Hotel;
import com.Junit.hms.hotel.SubCorridor;
import com.Junit.hms.sensors.MotionController;

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
		try {
			wait(60000);
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		
	}
}
}