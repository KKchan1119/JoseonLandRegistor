package com.entity;
public class LendReg {
    private int id;
    private String name;
    private int age;
    private int asset;
    private String address;
    LendReg(int id, String name, int age, int asset, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.asset = asset;
        this.address = address;
    }

    // ID
    public int getId(){
        return getId();
    }
    public void setId(int id){
        this.id = id;
    }

    //NAME
    public String getName(){
        return getName();
    }
    public void setName(String name){
        this.name = name;
    }

    //AGE
    public int getAge(){
        return getAge();
    }
    public void setAge(int age){
        this.age = age;
    }

    //ASSET
    public int getAsset(){
        return getAsset();
    }
    public void setAsset(int asset){
        this.asset=asset;
    }

    //ADDRESS
    public String getAddress(){
        return getAddress();
    }
    public void setAddress(String address){
        this.address = address;

    }

//
//    public int getAge(){
//        return getAge();
//    }
//    public void setAge(int age){
//        this.age = age;
//    }
//
//    public LendReg(){}
//    public LendReg(String name, int age, String address){
//        super();
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }
//    public String toString(){
//        return "\n이름: " + name + "\n나이: " + age + "\n주소: " + address;
//    }
}
