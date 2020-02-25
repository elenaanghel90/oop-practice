package com.elenaciuca.home.exercises.rodent;


public class ConcreteClass extends AbstractClass {
    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.print();
        test(new ConcreteClass());
    }
    public void print(){
        System.out.println("Hello");

    }
    public void print2(){
        System.out.println("Hello1");

    }
//    public static void test(AbstractClass abstractClass){
//        ((ConcreteClass)abstractClass).print();
//    }
//
    public static void test(AbstractClass abstractClass){

        abstractClass.print();
        ((ConcreteClass)abstractClass).print2();
    }


}
