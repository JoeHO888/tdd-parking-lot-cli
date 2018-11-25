package com.oocl.cultivation;

import sun.security.krb5.internal.Ticket;

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

    public int getManagementListLength(){
        return managementList.size();
    }

    public ParkingTicket assignParkingBoyToPark(ParkingBoy parkingBoy, Car car){
        return parkingBoy.park(car);
    }

    public Car assignParkingBoyToFetch(ParkingBoy parkingBoy, ParkingTicket ticket){
        return parkingBoy.fetch(ticket);
    }

    public String getLastErrorMessage(ParkingBoy parkingBoy){
        return parkingBoy.getLastErrorMessage();
    }


}
