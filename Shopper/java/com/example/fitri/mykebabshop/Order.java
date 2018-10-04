package com.example.fitri.mykebabshop;

/**
 * Created by fitri on 17/12/2017.
 */

class Order {
    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    private String USER_ID;
    private String ID;
    private String Location="location";
    private String OrderItem="Item";
    private String Quantity="quantity";
    private String Price="price";
    private String extras = "extras";
    private String meatType="meat";

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
}
