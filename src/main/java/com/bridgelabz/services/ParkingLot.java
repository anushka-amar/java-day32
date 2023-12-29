package com.bridgelabz.services;

import com.bridgelabz.entity.Attendant;
import com.bridgelabz.entity.Car;

import java.util.ArrayList;
import java.util.List;

/* contains list of parked cars and capacity
of parked cars, parks or unparks car accordingly */
public class ParkingLot {
    private List<Car> parkedCar;
    private int capacity;

    public ParkingLot(int capacity){
        this.parkedCar = new ArrayList<>();
        this.capacity = capacity;
    }

    /* UC-1 if the capacity is not full,
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

    /* UC-2 iterates through the list, if car found then
     *  unparks the car */
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

    /* checks in the list, if a car with corresponding
    * carId exists then returns true */
    public boolean check_parked(String carId) {
        for(Car car:parkedCar){
            if (car.getCarId().equals(carId)){
                return true;
            }
        }
        return false;
    }

    /* UC-3 checks if the number of parked car is not equal to
    * the capacity then return remaining slots
    * else notifies airport security*/
    public String check_parking_status() {
        if(this.parkedCar.size() != this.capacity){
            int slots = this.capacity - this.parkedCar.size();
            System.out.println(notify_owner_isEmpty());
            return notify_owner_isEmpty();
        }
        notify_owner_isFull();
        return notify_security();
    }

    /* UC-3 notifies owner if the parking lot is full
    * so that the full sign can be put out */
    private void notify_owner_isFull() {
        System.out.println("The Parking lot is full now");
    }

    /* UC-4 if the parking lot is full, notifies
    * the airport security to redirect staffs */
    private String notify_security(){
        return "Please redirect Security staffs";
    }

    /* UC-5 if Parking lot has space notifies the
    * owner to remove full sign board */
    private String notify_owner_isEmpty() {
        return "Slots are available in the Parking lot.";
    }

    /* UC-6 overloads the parkCar method above
    * to pass a corresponding attendant who will park the car */
    public boolean parkCar(Car car, Attendant attendant){
        if(parkedCar.size()<capacity){
            parkedCar.add(car);
            System.out.println("Car with ID: "+car.getCarId()+" has successfully been parked by Attendant: "+attendant.getAttId());
            return true;
        }
        System.out.println("Parking lot is full. Cannot park");
        return false;
    }
}
