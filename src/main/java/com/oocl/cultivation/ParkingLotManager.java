package com.oocl.cultivation;

import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {

    private List<ParkingBoy> managementList = new ArrayList<ParkingBoy>();
    private final ParkingLot[] parkingLotArray;
    private  ParkingLot parkingLot;
    private String lastErrorMessage = "Unrecognized parking ticket.";

    public ParkingLotManager(ParkingLot[] parkingLotArray) {
        this.parkingLotArray = parkingLotArray;
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

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        for (int i = 0; i < parkingLotArray.length; i++) {
            parkingLot = parkingLotArray[i];
            if (parkingLot.getAvailableParkingPosition()>0) {
                ParkingTicket ticket = new ParkingTicket(car);
                parkingLot.addCarTicketPair(ticket,car);
                lastErrorMessage = null;
                return ticket;
            }
        }
        lastErrorMessage = "Not enough position.";
        return null;
    }


    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method
        if (ticket!=null){
            if (ticket.availability) {
                return ticket.getCar();
            }else{
                lastErrorMessage = "Unrecognized parking ticket.";
                return null;
            }
        }else{
            lastErrorMessage = "Please provide your parking ticket.";
            return  null;
        }
    }

}
