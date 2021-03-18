package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    Map<Integer, String> userData = new HashMap<>();

    public String get(int key){

        System.out.println(userData.get(key));
        return userData.get(key);
    }

    public void set(int key, String value){

        userData.put(key,value);
    }

    public boolean has(int key){
        boolean boo = false;
        if (userData.containsKey(key)) {
            boo = true;
        }
        System.out.println(boo);
        return boo;
    }

    public void delete(int key){
        userData.remove(key);
    }


}
