package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyFactsStoryThree {
    // Story 3 AC 1
    @Test
    void should_park_car_when_previous_parkinglot_is_full() {
        final int capacity = 1;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(capacity);
        ParkingLot parkingLotB = new ParkingLot(capacity);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);

        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        assertEquals(0, parkingLotA.getAvailableParkingPosition());
        assertEquals(0, parkingLotB.getAvailableParkingPosition());
    }
}
