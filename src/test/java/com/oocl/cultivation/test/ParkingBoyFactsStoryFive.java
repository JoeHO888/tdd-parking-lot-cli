package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyFactsStoryFive {
    // Story 5 AC 1
    @Test
    void should_park_car_to_emptiest_parkinglot_in_terms_of_capacity_percentage() {
        final int capacityA = 9;
        final int capacityB = 100;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(capacityA);
        ParkingLot parkingLotB = new ParkingLot(capacityB);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotArray);

        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());


        assertEquals(7, parkingLotA.getAvailableParkingPosition());
        assertEquals(87, parkingLotB.getAvailableParkingPosition());
    }
}
