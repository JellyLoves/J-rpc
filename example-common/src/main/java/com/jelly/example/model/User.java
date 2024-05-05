package com.jelly.example.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1930970965917382230L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
