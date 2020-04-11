package com.jay.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty
    private long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String phone;

    @JsonProperty
    private String address;

    public Person() {

    }

    public Person(long id,String name,String phone, String address){
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
