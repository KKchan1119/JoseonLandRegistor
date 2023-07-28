package com.lr.controller;

import com.lr.Container;
import com.lr.DB.DB_JobInfo;

public class JobController {
    DB_JobInfo jobInfo = new DB_JobInfo();

    public void write(){
        System.out.println("추가할 직업 정보를 입력해주세요.");

        System.out.print("직업ID: ");
        String inputId = Container.getScanner().nextLine().trim();
        int jobIdIn = Integer.parseInt(inputId);
        System.out.print("서열: ");
        String inputRank = Container.getScanner().nextLine().trim();
        int jobRankIn = Integer.parseInt(inputRank);
        System.out.print("직업명: ");
        String inputJobName = Container.getScanner().nextLine().trim();
        String jobNameIn = inputJobName;
        System.out.print("직업정보: ");
        String inputJobInfo = Container.getScanner().nextLine().trim();
        String jobInfoIn = inputJobInfo;
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
