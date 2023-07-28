package com.lr.entity;

public class Job {
    private int id;
    private int rank;
    private String jobName;
    private String jobInfo;

    public Job(int id, int rank, String job, String info){
        this.id = id;
        this.rank = rank;
        this.jobName = job;
        this.jobInfo = info;
    }

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getJob() {
        return jobName;
    }

    public String getInfo() {
        return jobInfo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setJob(String jobName) {
        this.jobName = jobName;
    }

    public void setInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }
}
