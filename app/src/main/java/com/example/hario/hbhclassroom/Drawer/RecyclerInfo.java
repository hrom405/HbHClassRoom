package com.example.hario.hbhclassroom.Drawer;

public class RecyclerInfo {
    private String name;
    private int count;

    public RecyclerInfo(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
