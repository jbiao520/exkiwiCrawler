package com.exkiwi.crawler.entity;

/**
 * Created by george on 2017/1/6.
 */
public class JdItem {
    private String name;
    private String price;
    private String oPrice;
    private String url;
    private String detail;
    private String avatar;
    public String getoPrice() {
        return oPrice;
    }

    public void setoPrice(String oPrice) {
        this.oPrice = oPrice;
    }


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
