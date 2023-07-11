package com;
import com.controller.Controller;
import com.controller.input;

import java.util.Scanner;


public class LandRegApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Controller ctrl = new Controller();
        int cmdNum;
        while (true){
            System.out.println("========조선 농민 토지 대장========");
            System.out.println("<<< 1. 입력>>> || " +
                    " <<< 2. 삭제>>> || " +
                    "<<< 3. 조회>>> || " +
                    "<<< 4. 갱신>>> || " +
                    "<<< 5. 프로그램 종료>>> || ");
            System.out.print("하달 : ");
            cmdNum = sc.nextInt();
            switch (cmdNum){
                case 1:
                    ctrl.insert();

                    break;
                case 2:
                    ctrl.delete();

                    break;
                case 3:
                    ctrl.search();

                    break;
                case 4:
                    ctrl.update();

                    break;
                default:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
            }
            System.out.println();
        }


    }


}
