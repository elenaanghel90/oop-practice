package com.elenaciuca.home.exercises.rodent;

public abstract class BasePrinter {
    int value2 = 5;

    public static void main(String[] args) {

        IntegerPrinte object = new IntegerPrinte();
        object.print();
    }

    public BasePrinter() {
        print();

    }

    public abstract void print();
}
