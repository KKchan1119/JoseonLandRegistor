package com.controller;
import java.util.Scanner;
import com.entity.LendReg;

public class Controller {
    Scanner sc = new Scanner(System.in);
    LendReg lendArr[] = new LendReg[20];

    boolean swit[] = new boolean[20];
    int pageNum;
    String cheak;

    String name;
    int age;
    String address;
    public Controller(){
        init();
    }
    public void init(){
        for (int i = 0; i < swit.length; i++){
            swit[i]=false;
        }
    }
    public void insert(){
        System.out.println();
        for (int i = 0; i < lendArr.length; i++){
            if(swit[lendArr.length-1]==true){
                System.out.println("페이지 추가 불가");
                return;
            }else if(swit [i]== false){
                System.out.println((i + 1) + "번 페이지에 작성 가능");
                break;
            }
        }
        System.out.print("이름: ");
        if(sc.hasNext()){name = sc.nextLine();}
        System.out.print("나이: ");
        if(sc.hasNext()){age = Integer.parseInt(sc.nextLine());}
        System.out.print("주소: ");
        if(sc.hasNext()){address = sc.nextLine();}

        for(int i = 0; i < lendArr.length; i++){
            if(swit[i] == false){
                swit[i] = true;
                pageNum = i + 1;
                lendArr[i] = new LendReg(name, age, address);
                System.out.println(pageNum + "번째 페이지 작성 됨.");
                break;
            }
        }

    }
    public void delete(){
        System.out.println("삭제 페이지 입력 : ");
        pageNum = sc.nextInt();
        sc.nextLine();
        swit[pageNum -1] = false;
        lendArr[pageNum -1] = null;

    }
    public void search(){
        System.out.println("검색 페이지: ");
        pageNum = sc.nextInt();
        sc.nextLine();
        System.out.println(lendArr[pageNum -1].toString());
    }
    public void update(){
        System.out.println("수정할 페이지 입력: ");
        pageNum = sc.nextInt();
        sc.nextLine();
        swit[pageNum -1] = false;
        lendArr[pageNum -1] = null;


        System.out.print("이름: ");
        if(sc.hasNext()){name = sc.nextLine();}
        System.out.print("나이: ");
        if(sc.hasNext()){age = Integer.parseInt(sc.nextLine());sc.nextLine();}
        System.out.print("주소: ");
        if(sc.hasNext()){address = sc.nextLine();}

        lendArr[pageNum -1 ] = new LendReg(name, age, address);
        System.out.println(pageNum+"번째 페이지 수정됨");

    }


}
