package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyFactsStoryFour {

    // Story 4 AC 1
    @Test
    void should_park_car_to_emptiest_parkinglot() {
        final int parkingLotACapacity = 9;
        final int parkingLotBCapacity = 10;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(parkingLotACapacity);
        ParkingLot parkingLotB = new ParkingLot(parkingLotBCapacity);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotArray);

        smartParkingBoy.park(new Car());

        assertEquals(9, parkingLotA.getAvailableParkingPosition());
        assertEquals(9, parkingLotB.getAvailableParkingPosition());
    }
}
