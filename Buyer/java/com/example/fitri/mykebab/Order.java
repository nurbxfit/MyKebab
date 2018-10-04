package com.example.fitri.mykebab;

/**
 * Created by fitri on 16/12/2017.
 */

public class Order {
    private String ID;
    //private String name="name";
    //private String phoneNumber="number";
    private String Location="location";
    private String OrderItem="Item";
    private String Quantity="quantity";
    private String Price="price";
    private String extras = "extras";
    private String meatType="meat";
/*
    public Order(String ID, String name, String phoneNumber, String location, String orderItem, String quantity, String price, String extras, String meatType) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Location = location;
        OrderItem = orderItem;
        Quantity = quantity;
        Price = price;
        this.extras = extras;
        this.meatType = meatType;
    }

    public Order(String name, String phoneNumber, String location, String orderItem, String quantity, String price, String extras, String meatType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        Location = location;
        OrderItem = orderItem;
        Quantity = quantity;
        Price = price;
        this.extras = extras;
        this.meatType = meatType;
    }

    */

    public Order(String ID, String location, String orderItem, String quantity, String price, String extras, String meatType) {
        this.ID = ID;
        Location = location;
        OrderItem = orderItem;
        Quantity = quantity;
        Price = price;
        this.extras = extras;
        this.meatType = meatType;
    }

    public Order() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    //public String getName() {return name;}

    //public void setName(String name) {this.name = name;}

    //public String getPhoneNumber() {return phoneNumber;}

    //public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getOrderItem() {
        return OrderItem;
    }

    public void setOrderItem(String orderItem) {
        OrderItem = orderItem;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public String returnAll()
    {
        String all = "Q: "+ Quantity + " P: "+ Price + " L: " + Location  + " Ex: " + extras ;
        return all;
    }
    //private boolean pickup;
}
