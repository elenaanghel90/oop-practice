package com.elenaciuca.home.exercises.polymorphism.music;
//wind is a type of instrument

public class Wind extends Instrument{

    public void play(Note n){
        System.out.println("Wind.play() " + n);
    }
}
