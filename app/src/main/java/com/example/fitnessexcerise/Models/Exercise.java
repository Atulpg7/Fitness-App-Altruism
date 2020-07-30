package com.example.fitnessexcerise.Models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Exercise implements Serializable{

    String name;
    int img;
    int noOfusers;

    public int getNoOfusers() {
        return noOfusers;
    }

    public void setNoOfusers(int noOfusers) {
        this.noOfusers = noOfusers;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
