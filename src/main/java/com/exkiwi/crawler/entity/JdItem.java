package com.exkiwi.crawler.entity;

/**
 * Created by george on 2017/1/6.
 */
public class JdItem {
    private String name;
    private String price;

    public String getoPrice() {
        return oPrice;
    }

    public void setoPrice(String oPrice) {
        this.oPrice = oPrice;
    }

    private String oPrice;
    public JdItem() {
    }
    public JdItem(String name, String price) {
        this.name = name;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
