package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public final int capacity;

    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return capacity-cars.size() ;
    }

    public void addCarTicketPair(ParkingTicket ticket, Car car){
        cars.put(ticket,car);
    }

    public int getCapacity(){
        return this.capacity;
    };
}
