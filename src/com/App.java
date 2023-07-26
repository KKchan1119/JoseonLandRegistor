package com;

import com.DB.DBConnection;
import com.DB.DB_CareerInfo;
import com.DB.DB_JobInfo;
import com.DB.DB_PeopleInfo;
import com.entity.Career;
import com.entity.LendReg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public void run(){
        Connection conn = new DBConnection().getConnection();
        DB_PeopleInfo cmd = new DB_PeopleInfo();
        DB_JobInfo jobcmd = new DB_JobInfo();
        DB_CareerInfo careercmd = new DB_CareerInfo();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner in = new Scanner(System.in);
        System.out.println("조 선 농 민 토 지 대 장");
        System.out.println("Ver_01");
        while (true) {
            System.out.println("============================================================");
            System.out.println("기입: 농민들의 이름 나이 재산 주소 를 입력하여 저장합니다.");
            System.out.println("조회: 기록된 농민들의 정보를 출력합니다.");
            System.out.println("삭제: 입력받은 id의 농민 정보를 삭제합니다.");
            System.out.println("수정: 기록된 농민의 정보를 삭제합니다");
            System.out.println("직업정보: 직업에 관련된 정보 항목입니다.");
            System.out.println("경력정보: 경력에 관련된 정보 항목입니다.");
            System.out.println("종료: 프로그램 종료.");
            System.out.print("명령어 입력: ");
            switch (in.nextLine()) {
                case "기입":
                    System.out.print("함자: ");
                    String nameIn = in.nextLine();
                    System.out.print("나이: ");
                    int ageIn = Integer.parseInt(in.nextLine());
                    System.out.print("재산: ");
                    int assetIn = Integer.parseInt(in.nextLine());
                    System.out.print("주소: ");
                    String addressIn = in.nextLine();
                    cmd.InsertPeople(nameIn, ageIn, assetIn, addressIn);
                    break;

                case "조회":
                    cmd.SelectPeople();
                    break;
                case "삭제":
                    cmd.DeletePeople(in.nextInt());
                    break;
                case "수정":
                    System.out.println("수정할 농민의 id를 입력하세요.");
                    LendReg lr = cmd.getPeople(Integer.parseInt(in.nextLine()));

                    System.out.print("함자, 나이, 재산, 주소 중 수정할 항목 입력: ");
                    switch (in.nextLine()) {
                        case "함자":
                            lr.setName(in.nextLine());
                            break;
                        case "나이":
                            lr.setAge(in.nextInt());
                            break;
                        case "재산":
                            lr.setAsset(in.nextInt());
                            break;
                        case "주소":
                            lr.setAddress(in.nextLine());
                            break;
                    }
                    cmd.UpdatePeople(lr);
                    break;

                case "직업정보":
                    System.out.print("직업조회, 직업추가, 직업삭제 중에 선택: ");
                    switch (in.nextLine()) {
                        case "직업조회":
                            jobcmd.SelectJob();
                            break;
                        case "직업추가":
                            System.out.print("직업ID: ");
                            int jobIdIn = Integer.parseInt(in.nextLine());
                            System.out.print("서열: ");
                            int jobRankIn = Integer.parseInt(in.nextLine());
                            System.out.print("직업명: ");
                            String jobNameIn = in.nextLine();
                            System.out.print("직업정보: ");
                            String jobInfoIn = in.nextLine();
                            jobcmd.InsertJob(jobIdIn, jobRankIn, jobNameIn, jobInfoIn);
                            break;
                        case "직업삭제":
                            jobcmd.DeleteJob(Integer.parseInt(in.nextLine()));
                            break;
                    }
                    break;
                case "경력정보":
                    System.out.print("경력조회, 경력추가, 경력삭제 중에 선택: ");
                    switch (in.nextLine()) {
                        case "경력조회":
                            careercmd.SelectCareer();
                        case "경력추가":
                            System.out.print("경력ID: ");
                            int careerIdIn = Integer.parseInt(in.nextLine());
                            System.out.print("이름: ");
                            int pidIn = Integer.parseInt(in.nextLine());
                            System.out.print("직업: ");
                            int jidIn = Integer.parseInt(in.nextLine());
                            System.out.print("봉금: ");
                            int salary = Integer.parseInt(in.nextLine());
                            System.out.print("년차: ");
                            int year = Integer.parseInt(in.nextLine());
                            System.out.print("일터: ");
                            String location = in.nextLine();
                            careercmd.InsertCareer(careerIdIn, pidIn, jidIn, salary, year, location);
                            break;
                        case "경력삭제":
                            careercmd.DeleteCareer(Integer.parseInt(in.nextLine()));
                            break;
                        case "경력수정":
                            System.out.println("수정할 경력의 id를 입력하세요.");
                            Career Cr = careercmd.getCareer(Integer.parseInt(in.nextLine()));
                            System.out.print("봉급, 경력, 지역 중 수정할 항목 입력: ");
                            switch (in.nextLine()) {
                                case "봉급":
                                    Cr.setSalary(Integer.parseInt(in.nextLine()));
                                    break;
                                case "경력":
                                    Cr.setYear(Integer.parseInt(in.nextLine()));
                                    break;
                                case "지역":
                                    Cr.setLocation(in.nextLine());
                                    break;
                            }
                            careercmd.UpdateCareer(Cr);
                            break;
                    }

                    break;
                case "종료":
                    System.exit(0);
            }
        }

    }
}
