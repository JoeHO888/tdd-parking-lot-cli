package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager extends ParkingBoy {

    private List<ParkingBoy> managementList = new ArrayList<ParkingBoy>();

    public ParkingLotManager(ParkingLot[] parkingLotArray) {
        super(parkingLotArray);
    }

    public void addParkingBoyToManagementList(ParkingBoy parkingBoy){
        managementList.add(parkingBoy);
    }

    public int getManagementList(){
        return managementList.size();
    }
}
