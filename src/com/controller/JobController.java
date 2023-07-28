package com.controller;

import com.Container;
import com.DB.DB_JobInfo;

public class JobController {
    DB_JobInfo jobInfo = new DB_JobInfo();

    public void write(){
        String cmd = Container.getScanner().nextLine().trim();
        System.out.print("직업ID: ");
        int jobIdIn = Integer.parseInt(cmd);
        System.out.print("서열: ");
        int jobRankIn = Integer.parseInt(cmd);
        System.out.print("직업명: ");
        String jobNameIn = cmd;
        System.out.print("직업정보: ");
        String jobInfoIn = cmd;
        jobInfo.InsertJob(jobIdIn, jobRankIn, jobNameIn, jobInfoIn);
    }

    public void Search(){
        jobInfo.SelectJob();
    }
    public void Delete(){
        String cmd = Container.getScanner().nextLine().trim();
        jobInfo.DeleteJob(Integer.parseInt(cmd));
    }


}
