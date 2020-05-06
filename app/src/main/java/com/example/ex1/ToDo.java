package com.example.ex1;

import java.util.ArrayList;

public class ToDo {
    boolean Done;
    String text;

    public ToDo(String text) {
        this.Done = false;
        this.text = text;
    }

    public ToDo(String text, boolean done)
    {
        this.Done = done;
        this.text = text;
    }

    static ArrayList<ToDo> dummyList() {
        ArrayList<ToDo> myList = new ArrayList<>();
        myList.add(new ToDo("task a"));
        myList.add(new ToDo("task b"));
        myList.add(new ToDo("task c"));
        return myList;
    }
}