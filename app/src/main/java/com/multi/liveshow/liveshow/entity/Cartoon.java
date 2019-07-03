package com.multi.liveshow.liveshow.entity;

import java.io.Serializable;


public class Cartoon implements Serializable {

    private int imageId;

    private String name;

    private String des;


    public Cartoon(int imageId, String name,String des) {
        this.imageId = imageId;
        this.name = name;
        this.des = des;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
