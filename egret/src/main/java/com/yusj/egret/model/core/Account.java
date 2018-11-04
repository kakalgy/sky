package com.yusj.egret.model.core;

import java.util.List;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 14:41
 **/
public class Account {

    private int crewId;
    private float total;
    private float available;
    private float reinforce;

    private List<Bullet> bulletList;

    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getAvailable() {
        return available;
    }

    public void setAvailable(float available) {
        this.available = available;
    }

    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(List<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    public float getReinforce() {
        return reinforce;
    }

    public void setReinforce(float reinforce) {
        this.reinforce = reinforce;
    }
}
