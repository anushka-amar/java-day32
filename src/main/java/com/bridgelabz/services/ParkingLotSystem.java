package com.bridgelabz.services;

import com.bridgelabz.entity.Car;

public class ParkingLotSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking lot system\n");

        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkCar(new Car("CR-ID-001", "Blue"));
        parkingLot.unpark("CR-ID-001");
    }
}
