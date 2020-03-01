package com.elenaciuca.home.exercises.thinkingInJavaBook;

public class Constructor {
    String string = "abc";
    String string2;
    String string3;

    Constructor(String string2){
        this.string2 = string2;
        string3 ="fs";
    }


    public static void main(String[] args) {
        Constructor constructor = new Constructor("dsaa");
        System.out.println(constructor.string);
        System.out.println(constructor.string2);
        System.out.println(constructor.string3);
    }

}
