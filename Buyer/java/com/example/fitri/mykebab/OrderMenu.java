package com.example.fitri.mykebab;

/**
 * Created by fitri on 16/12/2017.
 */

class OrderMenu {
    private String NAME;
    private String PRICE;
    private String DESCRIPTION;

    public OrderMenu(String NAME, String PRICE, String DESCRIPTION) {
        this.NAME = NAME;
        this.PRICE = PRICE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public OrderMenu() {
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}

