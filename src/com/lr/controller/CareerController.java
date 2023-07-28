package com.lr.controller;

import com.lr.Container;
import com.lr.DB.DB_CareerInfo;
import com.lr.entity.Career;

public class CareerController {
    DB_CareerInfo careerInfo = new DB_CareerInfo();

    public void Write(){

        System.out.print("경력ID: ");
        String inputCarrerId = Container.getScanner().nextLine().trim();
        int career = Integer.parseInt(inputCarrerId);
        System.out.print("이름: ");
        String inputNameId = Container.getScanner().nextLine().trim();
        int pid = Integer.parseInt(inputNameId);
        System.out.print("직업: ");
        String jobId = Container.getScanner().nextLine().trim();
        int jid = Integer.parseInt(jobId);
        System.out.print("봉금: ");
        String inputSalary = Container.getScanner().nextLine().trim();
        int salary = Integer.parseInt(inputSalary);
        System.out.print("년차: ");
        String inputYear = Container.getScanner().nextLine().trim();
        int year = Integer.parseInt(inputYear);
        System.out.print("일터: ");
        String location = Container.getScanner().nextLine().trim();
        careerInfo.InsertCareer(career, pid, jid, salary, year, location);

    }
    public void Search(){
        careerInfo.SelectCareer();
    }
    public void Update(){

        System.out.println("수정할 경력의 id를 입력하세요.");
        String id = Container.getScanner().nextLine().trim();
        Career Cr = careerInfo.getCareer(Integer.parseInt(id));
        System.out.print("봉급, 경력, 지역 중 수정할 항목 입력: ");
        String cmd = Container.getScanner().nextLine().trim();
        switch (cmd) {
            case "봉급":
                String salary = Container.getScanner().nextLine().trim();
                Cr.setSalary(Integer.parseInt(salary));
                break;
            case "경력":
                String year = Container.getScanner().nextLine().trim();
                Cr.setYear(Integer.parseInt(year));
                break;
            case "지역":
                String location = Container.getScanner().nextLine().trim();
                Cr.setLocation(location);
                break;
        }
        careerInfo.UpdateCareer(Cr);
    }
    public void Delete(){
        String cmd = Container.getScanner().nextLine().trim();
        careerInfo.DeleteCareer(Integer.parseInt(cmd));
    }

}
