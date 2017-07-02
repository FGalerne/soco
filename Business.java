package com.flo.soco;

/**
 * Created by florian on 26/06/17.
 */

public class Business {

    // Attributes
    int id;
    String company;
    String address;
    String postalCode;
    String town;

    //Constructor
    public Business(){
        super();

    }

    public Business(int id, String company, String address, String postalCode, String town){

        super();
        this.id = id;
        this.company = company;
        this.address = address;
        this.postalCode = postalCode;
        this.town = town;
    }

    // Getter and Setter
    public int getId(){
        return this.id;
    }

    public void setId (int id){

        this.id = id;
    }

    public String getCompany(){

        return this.company;
    }

    public void setCompany (String company){

        this.company = company;
    }

    public String getAddress(){

        return this.address;
    }

    public void setAddress (String address){

        this.address = address;
    }

    public String getPostalCode(){

        return this.postalCode;
    }

    public void setPostalCode (String postalCode){

        this.postalCode = postalCode;
    }

    public String getTown(){

        return this.town;
    }

    public void setTown (String town){

        this.town = town;
    }




}
