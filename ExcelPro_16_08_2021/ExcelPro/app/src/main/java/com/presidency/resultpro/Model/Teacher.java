package com.presidency.resultpro.Model;

import com.google.firebase.database.Exclude;

public class Teacher {
    private String registernumber;
    private String imageURL;
    private String key;
    private String password;
    private int position;

    public Teacher() {
        //empty constructor needed
    }
    public Teacher (int position){
        this.position = position;
    }
    public Teacher(String registernumber, String imageUrl ,String Des) {
        if (registernumber.trim().equals("")) {
            registernumber = "No Name";
        }
        this.registernumber = registernumber;
        this.imageURL = imageUrl;
        this.password = Des;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisternumber() {
        return registernumber;
    }
    public void setRegisternumber(String registernumber) {
        this.registernumber = registernumber;
    }
    public String getImageUrl() {
        return imageURL;
    }
    public void setImageUrl(String imageUrl) {
        this.imageURL = imageUrl;
    }
    @Exclude
    public String getKey() {
        return key;
    }
    @Exclude
    public void setKey(String key) {
        this.key = key;
    }
}
