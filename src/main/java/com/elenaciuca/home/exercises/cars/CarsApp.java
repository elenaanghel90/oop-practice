package com.elenaciuca.home.exercises.cars;

import java.util.ArrayList;
import java.util.List;

public class CarsApp {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car(Transmission.AUTOMATIC, Model.COUPE, "CLS"));
        carList.add(new Car(Transmission.AUTOMATIC, Model.SEDANE, "AMG"));
        carList.add(new Car(Transmission.MANUAL, Model.SEDANE,"Dacia"));
        carList.add(new Car(Transmission.MANUAL, Model.HATCHBACK, "A3"));
        carList.add(new Car(Transmission.MANUAL, Model.HATCHBACK,"Renault"));

        // ManagerImpl managerImpl = new ManagerImpl(carList);
        Manager manager = new ManagerImpl(carList);
        List<Car> searchResult = manager.selectCars(Model.HATCHBACK, Transmission.MANUAL);

        System.out.println(searchResult);
    }

}
