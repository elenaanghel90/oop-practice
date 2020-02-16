package com.elenaciuca.home.exercises.cars;

import java.util.List;

public interface Manager {

    List<Car> selectCars(Model model, Transmission trasmission);

}
