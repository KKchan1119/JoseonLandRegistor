package com.entity;

public class Job {
    private int id;
    private int rank;
    private String job;
    private String info;

    public Job(int id, int rank, String job, String info){
        this.id = id;
        this.rank = rank;
        this.job = job;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getJob() {
        return job;
    }

    public String getInfo() {
        return info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
