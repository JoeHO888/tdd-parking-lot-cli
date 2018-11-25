package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy {

    private final ParkingLot[] parkingLotArray;
    private  ParkingLot parkingLot;
    private String lastErrorMessage = "Unrecognized parking ticket.";
    private  int[] parkingLotCapacityArray;

    public SmartParkingBoy(ParkingLot[] parkingLotArray) {
        super(parkingLotArray);
        this.parkingLotArray = parkingLotArray;
        this.parkingLotCapacityArray = new int[parkingLotArray.length];
        updateParkingLotCapacityArray(this.parkingLotArray);
    }
    @Override

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        int indexOfChosenParkingLot = this.getIndexWithMaxValueInArray(this.parkingLotCapacityArray);
        if (indexOfChosenParkingLot!=-1){
            parkingLot = parkingLotArray[indexOfChosenParkingLot];
            ParkingTicket ticket = new ParkingTicket(car);
            parkingLot.addCarTicketPair(ticket,car);
            lastErrorMessage = null;
            updateParkingLotCapacityArray(this.parkingLotArray);
            return ticket;
        }else{
            lastErrorMessage = "Not enough position.";
            return null;
        }
    }

    private int getIndexWithMaxValueInArray(int[] parkingLotCapacityArray){
        int index = -1;
        int maxValue = 0;
        for (int i = 0; i < parkingLotCapacityArray.length; i++) {
            if(parkingLotCapacityArray[i]>maxValue){
                index = i;
                maxValue = parkingLotCapacityArray[i];
            }
        }
        return index;
    }

    private void updateParkingLotCapacityArray(ParkingLot[] parkingLotArray){
        for (int i = 0; i < this.parkingLotArray.length; i++) {
            parkingLot = this.parkingLotArray[i];
            parkingLotCapacityArray[i] = parkingLot.getAvailableParkingPosition();
        }

    }


}
