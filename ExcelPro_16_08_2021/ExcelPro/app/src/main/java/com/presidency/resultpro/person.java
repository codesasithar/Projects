package com.presidency.resultpro;

public class person
{
    // Variable to store data corresponding
    // to firstname keyword in database
    private String name;

    // Variable to store data corresponding
    // to lastname keyword in database
    private String registernumber;

    // Variable to store data corresponding
    // to age keyword in database
    private String status;

    // Mandatory empty constructor
    // for use of FirebaseUI
    public person() {}

    // Getter and setter method
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }



    public String getRegisternumber()
    {
        return registernumber;
    }

    public void setRegisternumber(String registernumber)
    {
        this.registernumber = registernumber;
    }



    public String status()
    {
        return status;
    }



    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
}