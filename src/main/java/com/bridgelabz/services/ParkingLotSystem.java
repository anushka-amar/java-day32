package com.bridgelabz.services;

import com.bridgelabz.entity.Car;

public class ParkingLotSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking lot system");

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.parkCar(new Car("CR-ID-001", "Blue"));
    }
}
