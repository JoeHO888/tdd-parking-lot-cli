
package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy {

    private final ParkingLot[] parkingLotArray;
    private  ParkingLot parkingLot;
    private String lastErrorMessage = "Unrecognized parking ticket.";
    private  double[] parkingLotCapacityPercentageArray;

    public SuperSmartParkingBoy(ParkingLot[] parkingLotArray) {
        super(parkingLotArray);
        this.parkingLotArray = parkingLotArray;
        this.parkingLotCapacityPercentageArray = new double[parkingLotArray.length];
        updateParkingLotCapacityPercentageArray(this.parkingLotArray);
    }
    @Override

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        int indexOfChosenParkingLot = this.getIndexWithMaxValueInArray(this.parkingLotCapacityPercentageArray);
        if (indexOfChosenParkingLot!=-1){
            parkingLot = parkingLotArray[indexOfChosenParkingLot];
            ParkingTicket ticket = new ParkingTicket(car);
            parkingLot.addCarTicketPair(ticket,car);
            lastErrorMessage = null;
            updateParkingLotCapacityPercentageArray(this.parkingLotArray);
            return ticket;
        }else{
            lastErrorMessage = "Not enough position.";
            return null;
        }
    }

    private int getIndexWithMaxValueInArray(double[] parkingLotCapacityPercentageArray){
        int index = -1;
        double maxValue = 0;
        for (int i = 0; i < parkingLotCapacityPercentageArray.length; i++) {
            if(parkingLotCapacityPercentageArray[i]>maxValue){
                index = i;
                maxValue = parkingLotCapacityPercentageArray[i];
            }
        }
        return index;
    }

    private void updateParkingLotCapacityPercentageArray(ParkingLot[] parkingLotArray){
        for (int i = 0; i < this.parkingLotArray.length; i++) {
            parkingLot = this.parkingLotArray[i];
            parkingLotCapacityPercentageArray[i] = (1.0*parkingLot.getAvailableParkingPosition())/parkingLot.getCapacity();
        }

    }


}