package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage = "Unrecognized parking ticket.";

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        if (parkingLot.getAvailableParkingPosition()>0) {
            ParkingTicket ticket = new ParkingTicket(car);
            parkingLot.addCarTicketPair(ticket,car);
            lastErrorMessage = null;
            return ticket;
        }else{
            lastErrorMessage = "Not enough position.";
            return null;
        }
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

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
