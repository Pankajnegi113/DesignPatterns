package com.java.design.pattern.main;

enum VehicleType{
    TWO_WHEELER,
    FOUR_WHEELER;
}

enum Wheeler{
    BIKE,
    SCOOTY,
    CYCLE,
    CAR,
    TRUCK,
    AUTO;
}

interface VehicleI{
    public void run();
}

class Bike implements VehicleI{
    @Override
    public void run() {
        System.out.println("Bike is Running");
    }
}
class Scooty implements VehicleI{
    @Override
    public void run() {
        System.out.println("Scooty is Running");
    }
}
class Cycle implements VehicleI{
    @Override
    public void run() {
        System.out.println("Cycle is Running");
    }
}

class Car implements VehicleI{
    @Override
    public void run() {
        System.out.println("Car is Running");
    }
}

class Truck implements VehicleI{
    @Override
    public void run() {
        System.out.println("Truck is Running");
    }
}

class Auto implements VehicleI{
    @Override
    public void run() {
        System.out.println("Auto is Running");
    }
}

class VehicleFactory{
    public VehicleI getVehicleFactory(VehicleType vehicleType,Wheeler wheeler){
        switch (vehicleType){
            case TWO_WHEELER:
                TwoVehicleFactory twoVehicleFactory = new TwoVehicleFactory();
                return twoVehicleFactory.getVehicle(wheeler);
            case FOUR_WHEELER:
                FourVehicleFactory fourVehicleFactory = new FourVehicleFactory();
                return fourVehicleFactory.getVehicle(wheeler);
            default:
                return null;
        }

    }
}

class TwoVehicleFactory{

    public VehicleI getVehicle(Wheeler wheeler) {
        switch (wheeler){
            case BIKE:
                return new Bike();
            case SCOOTY:
                return new Scooty();
            case CYCLE:
                return new Cycle();
            default:
                return null;
        }
    }
}

class FourVehicleFactory{

    public VehicleI getVehicle(Wheeler wheeler) {
        switch (wheeler){
            case CAR:
                return new Car();
            case TRUCK:
                return new Truck();
            case AUTO:
                return new Auto();
            default:
                return null;
        }
    }
}


//FACTORY OF FACTORY
/*
If we have vehicles based on two wheeler and four wheeler
Will create factory for two wheeler and four wheeler and there will be
separate factory for vehicles coming under these two types
*/
public class AbstractFactory {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        System.out.println("Two wheelers running - ");
        vehicleFactory.getVehicleFactory(VehicleType.TWO_WHEELER,Wheeler.BIKE).run();
        vehicleFactory.getVehicleFactory(VehicleType.TWO_WHEELER,Wheeler.SCOOTY).run();
        vehicleFactory.getVehicleFactory(VehicleType.TWO_WHEELER,Wheeler.CYCLE).run();

        System.out.println();
        System.out.println("Four wheelers running - ");
        vehicleFactory.getVehicleFactory(VehicleType.FOUR_WHEELER,Wheeler.CAR).run();
        vehicleFactory.getVehicleFactory(VehicleType.FOUR_WHEELER,Wheeler.TRUCK).run();
        vehicleFactory.getVehicleFactory(VehicleType.FOUR_WHEELER,Wheeler.AUTO).run();
    }
}
