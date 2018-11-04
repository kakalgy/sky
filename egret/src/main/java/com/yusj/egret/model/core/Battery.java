package com.yusj.egret.model.core;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 13:40
 **/
public class Battery {

    private String uuid;
    private int quantity;
    private boolean direction;
    private float price;
    private long time;
    private int crewId;

    public Battery() {
    }

    public Battery(String uuid, int quantity, boolean direction, float price, long time, int crewId) {
        this.uuid = uuid;
        this.quantity = quantity;
        this.direction = direction;
        this.price = price;
        this.time = time;
        this.crewId = crewId;
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

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }
}
