package com.pavlovar.xml.patterns;

/**
 * Created by artempavlovskyi on 04/01/2017.
 */
public class FactoryPattern {
    public static void main(String[] args) {
        VehicleFactory factory = getFactory("M");
        Vehicle v = factory.createVehicle();
        v.sayHello();

    }
    public static VehicleFactory getFactory(String name) {
        if (name.equals("P")) {
            return new PorscheFactory();
        } else if (name.equals("M")) {
            return new MercedesFactory();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

interface Vehicle {
    void sayHello();
}
class Mercedes implements Vehicle {

    public void sayHello() {
        System.out.println("Hello, I am Mercedes");
    }
}
class Porsche implements Vehicle {

    public void sayHello() {
        System.out.println("Hello, I am Porsche");
    }
}

interface VehicleFactory {
    Vehicle createVehicle();
}
class MercedesFactory implements VehicleFactory{

    public Vehicle createVehicle() {
        return new Mercedes();
    }
}
class PorscheFactory implements VehicleFactory{

    public Vehicle createVehicle() {
        return new Porsche();
    }
}