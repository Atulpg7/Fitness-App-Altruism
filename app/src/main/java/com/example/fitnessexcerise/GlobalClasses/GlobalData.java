package com.example.fitnessexcerise.GlobalClasses;

import android.os.Parcelable;

import com.example.fitnessexcerise.Models.Exercise;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GlobalData{

    public static ArrayList<Exercise> list = new ArrayList<>();
    static int users;

    public static int getUsers() {
        return users;
    }

    public static void setUsers(int users) {
        GlobalData.users = users;
    }
}
