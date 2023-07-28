package com.view;

public class UI {
    public void title(){
        System.out.println("조 선 농 민 토 지 대 장");
    }
    public void version(){
        System.out.println("Ver_04");
    }

    public void mainUI(){
        System.out.println("============================================================");
        System.out.println("인원,직업,경력추가: 농민들의 이름 나이 재산 주소 를 입력하여 저장합니다.");
        System.out.println("인원,직업,경력조회: 기록된 농민들의 정보를 출력합니다.");
        System.out.println("인원,직업,경력삭제: 입력받은 id의 농민 정보를 삭제합니다.");
        System.out.println("인원,경력수정: 기록된 농민의 정보를 삭제합니다");
        System.out.println("종료: 프로그램 종료.");
        System.out.print("명령어 입력: ");
    }
}
