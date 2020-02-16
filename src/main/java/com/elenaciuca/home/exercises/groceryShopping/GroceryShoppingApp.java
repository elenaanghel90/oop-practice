package com.elenaciuca.home.exercises.groceryShopping;
/*Grocery Shopping


Create class Product, it should contain at least two fields – name and price.
Create an empty array of Products – it’s size should be at least 5.
Populate the array with some products - this array represents the menu for the user.
Simulate the process of doing shopping:

ask for a product,
add it to the cart (array),
change index,
if index will be greater than 5 – finish shopping,
pay for the products.*/

import java.util.Arrays;
import java.util.Scanner;

public class GroceryShoppingApp {

    public static void main(String[] args) {

        Product[] arrayProducts = new Product[6];
        //Product product1 = new Product("bread", 1.5);
        arrayProducts[0] = new Product("bread", 1.5);
        arrayProducts[1] = new Product("juice", 2.75);
        arrayProducts[2] = new Product("orange", 7);
        arrayProducts[3] = new Product("banana", 3.60);
        arrayProducts[4] = new Product("water", 2);
        arrayProducts[5] = new Product("bag", 5);

        Scanner scan = new Scanner(System.in);
        Shop shop = new Shop(arrayProducts);
        Cart cart = new Cart();

        while (true) {
            showTheMenu();
            Integer option = Integer.parseInt(scan.nextLine().trim());

            switch (option) {
                case 1:
                    System.out.println(Arrays.toString(arrayProducts));
                    break;
                case 2:
                    System.out.print("Type the desired product of a product: ");
                    String desiredProductName = scan.nextLine();
                    Product product = shop.selectAProductByName(desiredProductName);
                    cart.addToCart(product);
                    if (cart.isFull()) {
                        double totalPrice = cart.computeTotalPrice();
                        System.out.println(totalPrice);
                    }
                    break;
                case 3:
                    scan.close();
                    return;
                default:
                    System.out.println("Please choose an option from menu! ");
            }
        }
    }

    public static void showTheMenu() {
        System.out.println("1. Show the list of products.");
        System.out.println("2. Select a product from the list: ");
    }

}
