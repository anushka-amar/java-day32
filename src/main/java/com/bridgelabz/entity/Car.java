package com.bridgelabz.entity;

public class Car {
    private String carId;
    private String color;

    public Car(String carId, String color) {
        this.carId = carId;
        this.color = color;
    }

    public String getCarId() {
        return carId;
    }

    public String getColor() {
        return color;
    }
}
