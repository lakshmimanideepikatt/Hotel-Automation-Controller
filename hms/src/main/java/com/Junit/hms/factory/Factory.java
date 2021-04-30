package com.Junit.hms.factory;

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
