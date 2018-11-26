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
        final int parkingLotACapacity = 9;
        final int parkingLotBCapacity = 100;
        final int carNumber = 15;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(parkingLotACapacity);
        ParkingLot parkingLotB = new ParkingLot(parkingLotBCapacity);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotArray);
        for (int _ = 0; _ < carNumber; _++) {
            superSmartParkingBoy.park(new Car());
        }

        assertEquals(7, parkingLotA.getAvailableParkingPosition());
        assertEquals(87, parkingLotB.getAvailableParkingPosition());
    }
}
