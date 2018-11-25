package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_park_a_car_to_a_parking_lot_and_get_it_back() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.park(car);

        Car fetched = parkingBoy.fetch(ticket);

        assertSame(fetched, car);
    }

    @Test
    void should_park_multiple_cars_to_a_parking_lot_and_get_them_back() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket firstTicket = parkingBoy.park(firstCar);
        ParkingTicket secondTicket = parkingBoy.park(secondCar);

        Car fetchedByFirstTicket = parkingBoy.fetch(firstTicket);
        Car fetchedBySecondTicket = parkingBoy.fetch(secondTicket);

        assertSame(firstCar, fetchedByFirstTicket);
        assertSame(secondCar, fetchedBySecondTicket);
    }

    @Test
    void should_not_fetch_any_car_once_ticket_is_wrong() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);
        Car car = new Car();
        ParkingTicket wrongTicket = new ParkingTicket();

        ParkingTicket ticket = parkingBoy.park(car);

        assertNull(parkingBoy.fetch(wrongTicket));
        assertSame(car, parkingBoy.fetch(ticket));
    }

    @Test
    void should_query_message_once_the_ticket_is_wrong() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);
        ParkingTicket wrongTicket = new ParkingTicket();

        parkingBoy.fetch(wrongTicket);
        String message = parkingBoy.getLastErrorMessage();

        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_clear_the_message_once_the_operation_is_succeeded() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);
        ParkingTicket wrongTicket = new ParkingTicket();

        parkingBoy.fetch(wrongTicket);
        assertNotNull(parkingBoy.getLastErrorMessage());

        ParkingTicket ticket = parkingBoy.park(new Car());
        assertNotNull(ticket);
        assertNull(parkingBoy.getLastErrorMessage());
    }

    @Test
    void should_not_fetch_any_car_once_ticket_is_not_provided() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);
        Car car = new Car();

        ParkingTicket ticket = parkingBoy.park(car);

        assertNull(parkingBoy.fetch(null));
        assertSame(car, parkingBoy.fetch(ticket));
    }

    @Test
    void should_query_message_once_ticket_is_not_provided() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);

        parkingBoy.fetch(null);

        assertEquals(
            "Please provide your parking ticket.",
            parkingBoy.getLastErrorMessage());
    }

    @Test
    void should_not_fetch_any_car_once_ticket_has_been_used() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);
        Car car = new Car();

        ParkingTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);

        assertNull(parkingBoy.fetch(ticket));
    }

    @Test
    void should_query_error_message_for_used_ticket() {
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot();
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);
        Car car = new Car();

        ParkingTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        parkingBoy.fetch(ticket);

        assertEquals(
            "Unrecognized parking ticket.",
            parkingBoy.getLastErrorMessage()
        );
    }

    @Test
    void should_not_park_cars_to_parking_lot_if_there_is_not_enough_position() {
        final int capacity = 1;
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);

        parkingBoy.park(new Car());

        assertNull(parkingBoy.park(new Car()));
    }

    @Test
    void should_get_message_if_there_is_not_enough_position() {
        final int capacity = 1;
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);

        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        assertEquals("Not enough position.", parkingBoy.getLastErrorMessage());
    }
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

    // Story 4 AC 1
    @Test
    void should_park_car_to_emptiest_parkinglot() {
        final int capacityA = 9;
        final int capacityB = 10;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(capacityA);
        ParkingLot parkingLotB = new ParkingLot(capacityB);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotArray);

        smartParkingBoy.park(new Car());

        assertEquals(9, parkingLotA.getAvailableParkingPosition());
        assertEquals(9, parkingLotB.getAvailableParkingPosition());
    }

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

}
