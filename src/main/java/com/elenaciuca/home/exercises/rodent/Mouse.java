package com.elenaciuca.home.exercises.rodent;

public class Mouse extends Rodent {

    @Override
    public void crunch() {
        System.out.println("croc croc");
    }

    @Override
    public void getSpecies() {
        System.out.println("mouse");
    }
    public void runFast(){
        System.out.println("The mouse run");
    }
}
