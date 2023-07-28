package com.entity;
public class People {
    private int id;
    private  String name;
    private  int age;
    private  int asset;
    private  String address;

    public People(int id, String name, int age, int asset, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.asset = asset;
        this.address = address;
    }

    // ID
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    //NAME

    public void setName(String name){
        this.name = name;
    }

    //AGE

    public void setAge(int age){
        this.age = age;
    }

    //ASSET

    public void setAsset(int asset){
        this.asset=asset;
    }

    //ADDRESS

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAsset() {
        return asset;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){
        this.address = address;

    }
}
