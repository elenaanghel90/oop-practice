package com.elenaciuca.home.exercises.cars;

//create a program that help you to select cars from a cars list filtering by the model(sedan, hatchback, sport etc) and transmission (auto, manual)

public class Car {

    private final Transmission transmission;
    private final Model model;
    private final String description;

    public Car(Transmission transmission, Model model, String description) {
        this.transmission = transmission;
        this.model = model;
        this.description = description;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Model getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "transmission=" + transmission +
                ", model=" + model +
                ", description=" + description +
                '}';
    }
}
