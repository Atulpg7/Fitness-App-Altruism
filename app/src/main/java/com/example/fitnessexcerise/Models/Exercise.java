package com.example.fitnessexcerise.Models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Exercise implements Serializable{

    String name;
    int img;

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
