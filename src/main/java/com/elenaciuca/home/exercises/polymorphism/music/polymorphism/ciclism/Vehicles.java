package com.elenaciuca.home.exercises.polymorphism.music.polymorphism.ciclism;

//demonstrating that the instance of each type of unicycle, bicycle and tricycle can be upcasted to the Cycle wia ride method
public class Vehicles {
    public static void main(String[] args) {
        Unicycle unicycle1 = new Unicycle();
        Bicycle bicycle1 = new Bicycle();
        Tricycle tricycle1 = new Tricycle();

        ride(unicycle1);
        ride(bicycle1);
        ride(tricycle1);

        Vehicles vehicle = new Vehicles();
        vehicle.getColor();
    }

    public static void ride( Unicycle unicycle){
        unicycle.rideWithSpeed(Speed.SPEED_1);
    }
    public static void ride( Bicycle bicycle){
        bicycle.rideWithSpeed(Speed.SPEED_2);
    }
    public static void ride( Tricycle tricycle){
        tricycle.rideWithSpeed(Speed.SPEED_3);
    }
    public void getColor(){
        System.out.println("The cycle has the color red");
    }
}
