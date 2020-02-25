package com.elenaciuca.home.exercises.rodent;

public class Hamster extends Rodent {

    @Override
    public void crunch() {
        System.out.println("hrum hrum");
    }

    @Override
    public void getSpecies() {
        System.out.println("hamster");
    }
}
