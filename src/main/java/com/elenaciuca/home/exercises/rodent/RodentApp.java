package com.elenaciuca.home.exercises.rodent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodentApp {
    public static void main(String[] args) {
        Mouse mouse1 = new Mouse();
        Gerbil gerbil1 = new Gerbil();
        Hamster hamster1 = new Hamster();

        List<Rodent> rodentList = new ArrayList<Rodent>();
        rodentList = Arrays.asList(mouse1, gerbil1, hamster1);
//        rodentList.add(mouse1);
//        rodentList.add(gerbil1);
//        rodentList.add(hamster1);

        for (Rodent rodent: rodentList) {
            rodent.getSpecies();
            rodent.crunch();
            rodent.run();
        }
    }

}
