package com.example.inthepocket;

public class User {
    String name;
    String address = "a";
    String location = "l";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User(String name) {
        super();
        this.name = name;
    }

}


