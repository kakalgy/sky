package com.yusj.egret.model.core;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 14:46
 **/
public class Bullet {

    private String uuid;
    private int quantity;
    private float price;

    public Bullet(String uuid, int quantity, float price) {
        this.uuid = uuid;
        this.quantity = quantity;
        this.price = price;
    }

    public Bullet() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
