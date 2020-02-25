package com.elenaciuca.home.exercises.rodent;
//from the book Thinking in Java pag 289 ex 9

public abstract class Rodent {

    public abstract void crunch();

    public abstract void getSpecies();

    public void run() {
        System.out.println("vrum vrum");
    }
    public static void run(Rodent rodent){
        ((Mouse)rodent).runFast();
    }
}
