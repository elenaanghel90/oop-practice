package com.elenaciuca.home.exercises.cars;

import java.util.ArrayList;
import java.util.List;

public class ManagerImpl implements Manager {

    private List<Car> carList;

    public ManagerImpl(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> selectCars(Model model, Transmission transmission) {
        List<Car> foundCars = new ArrayList<Car>();

        for (Car car : carList) {
            if (car.getModel() == model && car.getTransmission() == transmission) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }
}
