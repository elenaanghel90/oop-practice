package com.elenaciuca.home.exercises.cars;


public class Car {

    private final Transmission transmission;
    private final Model model;
    private final Fuel fuel;
    private final String description;

    public Car(Transmission transmission, Model model, Fuel fuel, String description) {
        this.transmission = transmission;
        this.model = model;
        this.fuel = fuel;
        this.description = description;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Model getModel() {
        return model;
    }

    public Fuel getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "The result of your search is: " +
                "transmission=" + transmission +
                ", model=" + model +
                ", description=" + description +
                ", fuel= " + fuel;
    }
}
