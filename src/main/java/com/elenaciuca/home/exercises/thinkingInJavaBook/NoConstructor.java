package com.elenaciuca.home.exercises.thinkingInJavaBook;

public class NoConstructor {

    String string;

    public static void main(String[] args) {
        NoConstructor noConstructor = new NoConstructor();
        System.out.println(noConstructor.string);
    }
}
