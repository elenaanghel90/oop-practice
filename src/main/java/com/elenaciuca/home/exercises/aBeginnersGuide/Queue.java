package com.elenaciuca.home.exercises.aBeginnersGuide;

public class Queue {
    char q[]; // the array holds the queue
    int putLoc, getLoc; //the put and get indices

    public Queue(int size) {
        q = new char[size]; //allocate the memory for queue
        putLoc = getLoc = 0;
    }

    public void put(char ch) {
        if (putLoc == q.length) {
            System.out.println("The queue is full!");
            return;
        } else {
            q[putLoc++] = ch;
        }
    }

    public char get() {
        if (putLoc == getLoc) {
            System.out.println("The queue is empty!");
            return (char) 0;
        } else {
            return q[getLoc++];
        }
    }

    public static void main(String[] args) {
        Queue queue1 = new Queue(26);
        Queue queue2 = new Queue(2);
        char ch;
        int i;

        System.out.println("Using queue 1 to store the alphabet:");
        for (i = 0; i < 26; i++) {
            queue1.put((char) ('A' + i));
        }
        System.out.println("Return the content of queue 1: ");
        for(i = 0; i < 26; i++){
            ch = queue1.get();
            if(ch != (char) 0){
                System.out.print(ch);
            }
        }
        System.out.println("\n");

        System.out.println("Using queue 2 to generate the errors.");
        for(i = 0; i < 2; i++){
            System.out.println("Attempting the store " + (char) ('Z' - i));
            queue2.put((char) ('Z' - i));
            System.out.println();
        }
        System.out.println();

        System.out.println("Return the contnt of the queue 2");
        for(i = 0; i < 2; i++){
            ch = queue2.get();

            if(ch != (char) 0){
                System.out.println(ch);
            }
        }
    }
}
