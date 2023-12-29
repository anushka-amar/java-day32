package com.bridgelabz.services;

import com.bridgelabz.entity.Car;

import java.util.ArrayList;
import java.util.List;

/*contains list of parked cars and capacity
of parked cars, parks or unparks car accordingly*/
public class ParkingLot {
    private List<Car> parkedCar;
    private int capacity;

    public ParkingLot(){
        this.parkedCar = new ArrayList<>();
        this.capacity = 100;
    }

    /* if the capacity is not full,
    * adds a new car to the list*/
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

    /* iterates through the list, if car found then
    * unparks the car */
    public void unpark(String carId) {
        for(Car car:parkedCar){
            if(car.getCarId().equals(carId)){
                parkedCar.remove(car);
                System.out.println("Car with ID: "+carId+" has been unparked Successfully!!");
                return;
            }
        }
        System.out.println("No car with ID: "+carId+" in this parking lot");
    }

    /* checks in the list, if a car with corrresponding
    * carId exists then returns true */
    public boolean check_parked(String carId) {
        for(Car car:parkedCar){
            if (car.getCarId().equals(carId)){
                return true;
            }
        }
        return false;
    }

    public String check_parking_status() {
        if(this.parkedCar.size() != this.capacity){
            int slots = this.capacity - this.parkedCar.size();
            return (slots+" slots are left in the parking lot");
        }
        return "Parking lot is Full. Please come later.";
    }
}
