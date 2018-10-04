package com.example.fitri.mykebabshop;

/**
 * Created by fitri on 17/12/2017.
 */

public class Users {
    private String ID;
    private Order myOrder;
    private String name;
    private String Phone;

    public Users() {
    }

    public Order getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(Order myOrder) {
        this.myOrder = myOrder;
    }

    public Users(String ID, Order myOrder, String name, String phone) {
        this.ID = ID;
        this.myOrder = myOrder;
        this.name = name;
        Phone = phone;
    }

    public Users(String ID, String name, String phone) {
        this.ID = ID;
        this.name = name;
        Phone = phone;
    }

    public Users(String name, String phone) {
        this.name = name;
        Phone = phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}