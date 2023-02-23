package com.example.femme_womenssafety;

import java.util.HashMap;
import java.util.Map;

public class Contact_store {
    private  String Name;
    private String Phone_number;

    private Map<String, Object> mp;

    public Contact_store() {
    }


    public Contact_store(String Name, String Phone_number) {
        this.Name = Name;
       this.Phone_number = Phone_number;

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String Phone_number) {
       this. Phone_number = Phone_number;
    }


    public Map<String, Object> toMap() {
        mp = new HashMap<>();
        mp.put("Name", this.Name);
        mp.put("Phone_number", this.Phone_number);



        return mp;
    }
}




















