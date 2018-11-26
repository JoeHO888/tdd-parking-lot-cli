package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingManagerFacts {

    // Story 6 AC 1
    @Test
    void should_add_parking_boy_to_management_list() {

        final int capacityA = 9;
        final int capacityB = 100;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(capacityA);
        ParkingLot parkingLotB = new ParkingLot(capacityB);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotArray);

        ParkingLot[] parkingLotArrayB = new ParkingLot[2];
        ParkingLot parkingLotC = new ParkingLot(capacityA);
        ParkingLot parkingLotD = new ParkingLot(capacityB);
        parkingLotArrayB[0] = parkingLotC;
        parkingLotArrayB[1] = parkingLotD;

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotArrayB);

        ParkingLot[] parkingLotArrayC = new ParkingLot[2];
        ParkingLot parkingLotE = new ParkingLot(capacityA);
        ParkingLot parkingLotF = new ParkingLot(capacityB);
        parkingLotArrayC[0] = parkingLotE;
        parkingLotArrayC[1] = parkingLotF;
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotArrayC);

        parkingLotManager.addParkingBoyToManagementList(superSmartParkingBoy);
        parkingLotManager.addParkingBoyToManagementList(smartParkingBoy);

        Car carA = new Car();
        ParkingTicket ticketA = parkingLotManager.assignParkingBoyToPark(smartParkingBoy,carA);

        Car fetchedA = parkingLotManager.assignParkingBoyToFetch(smartParkingBoy,ticketA);

        Car carB = new Car();
        ParkingTicket ticketB = parkingLotManager.assignParkingBoyToPark(superSmartParkingBoy,carB);

        Car fetchedB = parkingLotManager.assignParkingBoyToFetch(superSmartParkingBoy,ticketB);

        assertSame(fetchedA, carA);

        assertSame(fetchedB, carB);

        assertSame(2, parkingLotManager.getManagementListLength());
    }

    // Story 6 AC 2
    @Test
    void should_park_a_car_to_a_parking_lot_and_get_it_back_by_manager() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotArray);
        Car car = new Car();
        ParkingTicket ticket = parkingLotManager.park(car);

        Car fetched = parkingLotManager.fetch(ticket);

        assertSame(fetched, car);
    }

    // Story AC 3
    @Test
    void should_query_message_once_the_ticket_is_wrong_by_manager() {


        final int capacityA = 9;
        final int capacityB = 100;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(capacityA);
        ParkingLot parkingLotB = new ParkingLot(capacityB);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotArray);

        ParkingLot[] parkingLotArrayB = new ParkingLot[2];
        ParkingLot parkingLotC = new ParkingLot(capacityA);
        ParkingLot parkingLotD = new ParkingLot(capacityB);
        parkingLotArrayB[0] = parkingLotC;
        parkingLotArrayB[1] = parkingLotD;

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotArrayB);

        ParkingLot[] parkingLotArrayC = new ParkingLot[2];
        ParkingLot parkingLotE = new ParkingLot(capacityA);
        ParkingLot parkingLotF = new ParkingLot(capacityB);
        parkingLotArrayC[0] = parkingLotE;
        parkingLotArrayC[1] = parkingLotF;
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotArrayC);

        parkingLotManager.addParkingBoyToManagementList(superSmartParkingBoy);
        parkingLotManager.addParkingBoyToManagementList(smartParkingBoy);

        Car carA = new Car();
        ParkingTicket ticketA = parkingLotManager.assignParkingBoyToPark(smartParkingBoy,carA);

        Car fetchedA = parkingLotManager.assignParkingBoyToFetch(smartParkingBoy,ticketA);

        Car carB = new Car();
        ParkingTicket ticketB = parkingLotManager.assignParkingBoyToPark(superSmartParkingBoy,carB);

        Car fetchedB = parkingLotManager.assignParkingBoyToFetch(superSmartParkingBoy,ticketA);

        String message = parkingLotManager.getLastErrorMessage(superSmartParkingBoy);

        assertEquals("Unrecognized parking ticket.", message);
    }
}
