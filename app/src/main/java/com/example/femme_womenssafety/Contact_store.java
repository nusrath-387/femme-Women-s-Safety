package com.example.femme_womenssafety;

public class Contact_store {
    private  String Name;
    private String Phone_number;

    public Contact_store(String name, String phone_number) {
        Name = name;
        Phone_number = phone_number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }
}
