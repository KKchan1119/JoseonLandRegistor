package com.lr.entity;

public class Career {

    private int id;
    private int pid;
    private int jid;
    private int salary;
    private int year;
    private String location;

    public Career(int id, int pid, int jid, int salary, int year, String location) {
        this.id = id;
        this.pid = pid;
        this.jid = jid;
        this.salary = salary;
        this.year = year;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
