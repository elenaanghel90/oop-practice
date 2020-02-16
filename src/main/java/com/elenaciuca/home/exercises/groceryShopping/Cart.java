package com.elenaciuca.home.exercises.groceryShopping;


public class Cart {
    Product[] cartItems = new Product[5];
    int size = 0;

    public void addToCart(Product product) {
        cartItems[size] = product;
        size++;
    }
    public boolean isFull(){
        if(size == 5){
            return true;
        }
        return false;
    }

    public double computeTotalPrice(){
        double sumOfTotalPrices =0;
        for (Product product : cartItems) {
            double price = product.getPrice();
            sumOfTotalPrices += price;
        }
        return sumOfTotalPrices;
    }

}
