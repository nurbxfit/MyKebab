package com.example.fitri.mykebab;

/**
 * Created by fitri on 16/12/2017.
 */

public class Users {
    private String ID;
    private String name;
    private String Phone;

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
