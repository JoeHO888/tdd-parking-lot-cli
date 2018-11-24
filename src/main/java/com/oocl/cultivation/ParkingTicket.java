package com.oocl.cultivation;

public class ParkingTicket {
    private Car car;
    public Boolean availability = true;

    public ParkingTicket (Car car){this.car = car;}
    public ParkingTicket (){}

    public Car getCar() {
        availability = false;
        return this.car;
    }
}
