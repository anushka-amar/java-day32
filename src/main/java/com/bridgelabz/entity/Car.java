package com.bridgelabz.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* manages the property of each car in the list */
public class Car {
    private String carId;
    private String color;

    private LocalDateTime parked_time;

    public Car(String carId, String color) {
        this.carId = carId;
        this.color = color;
        this.parked_time = LocalDateTime.now(); //updates the time for parked car
    }

    public String getCarId() {
        return carId;
    }

    public String getColor() {
        return color;
    }

    public LocalDateTime getParked_time() {
        return parked_time;
    }

    public String getFormattedParkedTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return parked_time.format(formatter);
    }
}
