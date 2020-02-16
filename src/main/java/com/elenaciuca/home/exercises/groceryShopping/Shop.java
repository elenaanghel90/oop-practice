package com.elenaciuca.home.exercises.groceryShopping;

public class Shop {

    private Product[] arrayProducts;

    public Shop(Product[] arrayProducts) {
        this.arrayProducts = arrayProducts;
    }

    public Product selectAProductByName(String name) {

        for (Product product : arrayProducts) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

}
