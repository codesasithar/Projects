package com.presidency.resultpro;

public class Userinformation {

    public String registernumber;
    public String password;
    public String phoneno;

    public Userinformation(){
    }

    public Userinformation(String registernumber,String password, String phoneno){
        this.registernumber = registernumber;
        this.password = password;
        this.phoneno = phoneno;
    }
    public String getRegisternumber() {
        return registernumber;
    }
    public String getPassword() {
        return password;
    }
    public String getUserPhoneno() {
        return phoneno;
    }
}