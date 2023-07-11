package com.entity;

public class LendReg {
    private String name;
    private int age;
    private String address;

    public String getName(){
        return getName();
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return getAddress();
    }
    public void setAddress(String address){
        this.address = address;
    }

    public int getAge(){
        return getAge();
    }
    public void setAge(int age){
        this.age = age;
    }

    public LendReg(){}
    public LendReg(String name, int age, String address){
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String toString(){
        return "\n이름: " + name + "\n나이: " + age + "\n주소: " + address;
    }
}
