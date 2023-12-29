package com.bridgelabz.services;

import com.bridgelabz.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> parkedCar;
    private int capacity;

    public ParkingLot(){
        this.parkedCar = new ArrayList<>();
        this.capacity = 100;
    }

    public boolean parkCar(Car car){
        if(parkedCar.size()<capacity){
            parkedCar.add(car);
            System.out.println("Car with ID: "+car.getCarId()+" has been parked successfully!!");
            return true;
        }else {
            System.out.println("Parking lot is full. Cannot park");
            return false;
        }
    }

    public boolean check_parked(String carId) {
        for(Car car:parkedCar){
            if (car.getCarId().equals(carId)){
                return true;
            }
        }
        return false;
    }
}
