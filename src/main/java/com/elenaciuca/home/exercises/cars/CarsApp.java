package com.elenaciuca.home.exercises.cars;

import java.util.ArrayList;
import java.util.List;

public class CarsApp {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car(Transmission.AUTOMATIC, Model.COUPE, Fuel.OIL, "CLS"));
        carList.add(new Car(Transmission.AUTOMATIC, Model.SEDANE,Fuel.GAS,"AMG"));
        carList.add(new Car(Transmission.MANUAL, Model.SEDANE,Fuel.OIL,"Dacia"));
        carList.add(new Car(Transmission.MANUAL, Model.HATCHBACK, Fuel.OIL, "A3"));
        carList.add(new Car(Transmission.MANUAL, Model.HATCHBACK, Fuel.GAS,"Renault"));

        // ManagerImpl managerImpl = new ManagerImpl(carList);
        Manager manager = new ManagerImpl(carList);
        List<Car> searchResult = manager.selectCars(Model.HATCHBACK, Transmission.MANUAL, Fuel.OIL);

        System.out.println(searchResult);
    }

}
