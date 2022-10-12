package com.java.design.pattern.main;

/*
let say we have class vehicle, there can be multiple type of vehicle like car, bike, truck,cycle
If we make IS-A relationship between vehicle class and vehicle type then there can be huge chances of code duplicacy
as a behaviour can be common to multiple vehicleTypes.
Move that common behaviour to some strategy.and place it in parent i.e Vehicle and take value from contructor

So instead of having IS-A, change it to HAS-A, where we will be having strategy->SpeedStategy Interface -> FastMovingStrategy and SlowMovingStrategy

 */

interface SpeedStrategy{
    public void speed();
}

class FastMovingStrategy implements SpeedStrategy{
    @Override
    public void speed() {
        System.out.println("This is Fast Moving vehicle");
    }
}

class SlowMovingStrategy implements SpeedStrategy{
    @Override
    public void speed() {
        System.out.println("This is Slow Moving vehicle");
    }
}

class Vehicle{

    private SpeedStrategy speedStrategy;

    Vehicle(SpeedStrategy strategy){
        this.speedStrategy=strategy;
    }

    public void getSpeed(){
        speedStrategy.speed();
    }

}

class SportCar extends Vehicle{

    SportCar(SpeedStrategy strategy) {
        super(strategy);
    }
}

class ElectricBike extends Vehicle{

    ElectricBike(SpeedStrategy strategy) {
        super(strategy);
    }
}

class Aeroplane extends Vehicle{
    Aeroplane(SpeedStrategy strategy) {
        super(strategy);
    }
}

public class Strategy {
    public static void main(String[] args) {
        Vehicle aeroplane = new Aeroplane(new FastMovingStrategy());
        aeroplane.getSpeed();

        Vehicle electricBike = new ElectricBike(new SlowMovingStrategy());
        electricBike.getSpeed();

        Vehicle sportCar = new SportCar(new FastMovingStrategy());
        sportCar.getSpeed();
    }
}
