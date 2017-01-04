package com.pavlovar.xml.patterns;

/**
 * Created by artempavlovskyi on 04/01/2017.
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Car tesla = new CarBuilder()
                .setModel("Tesla")
                .setSpeed("100")
                .setTransmission(Car.Transmission.AUTO)
                .build();
        System.out.println(tesla);
    }
}

class Car {
    private String speed;
    private Transmission transmission;
    private String model;

    private Car() {

    }

    public static Car createNewCar() {
        return new Car();
    }

    public Car setSpeed(String speed) {
        this.speed = speed;
        return this;
    }

    public Car setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String toString() {
        return "Car[" + "speed=" + speed + ", transmission=" + transmission + ", model=" + model + ']';
    }

    enum Transmission {
        AUTO, MANUAL
    }
}

class CarBuilder {
    private String speed;
    private Car.Transmission transmission;
    private String model;

    public CarBuilder setSpeed(String speed) {
        this.speed = speed;
        return this;
    }

    public CarBuilder setTransmission(Car.Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public Car build() {
        Car car = Car.createNewCar();
        car.setModel(model);
        car.setSpeed(speed);
        car.setTransmission(transmission);
        return car;
    }
}
