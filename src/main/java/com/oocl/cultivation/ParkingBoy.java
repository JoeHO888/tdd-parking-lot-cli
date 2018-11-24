package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        ParkingTicket ticket = new ParkingTicket(car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method
        return ticket.getCar();
    }

    public String getLastErrorMessage() {
        return "Unrecognized parking ticket.";
    }
}
