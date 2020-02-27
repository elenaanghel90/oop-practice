package com.elenaciuca.home.exercises.polymorphism.music;

public class Music {
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
         // sau tune(new Wind());
    }

    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }

}
