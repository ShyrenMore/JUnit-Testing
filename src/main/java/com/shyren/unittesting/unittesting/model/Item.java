package com.shyren.unittesting.unittesting.model;

public class Item {
    private int id, price, quantity;
    private String name;

    public Item(int id, String name, int quantity, int price) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
    }
}
