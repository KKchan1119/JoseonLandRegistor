package com.lr.controller;

import com.lr.Container;
import com.lr.DB.DB_PeopleInfo;
import com.lr.entity.People;

public class PeopleController {
    DB_PeopleInfo peopleInfo = new DB_PeopleInfo();

    public void Write() {

        System.out.print("함자: ");
        String name = Container.getScanner().nextLine().trim();
        System.out.print("나이: ");
        String inputAge = Container.getScanner().nextLine().trim();
        int age = Integer.parseInt(inputAge);
        System.out.print("재산: ");
        String inputAsset = Container.getScanner().nextLine().trim();
        int asset = Integer.parseInt(inputAsset);
        System.out.print("주소: ");
        String address = Container.getScanner().nextLine().trim();
        peopleInfo.InsertPeople(name, age, asset, address);
    }
    public void Search() {
        peopleInfo.SelectPeople();
    }

    public void Delete() {
        String cmd = Container.getScanner().nextLine().trim();
        peopleInfo.DeletePeople(Integer.parseInt(cmd));
    }

    public void Update() {

        System.out.println("수정할 농민의 id를 입력하세요.");
        String id = Container.getScanner().nextLine().trim();
        People Pp = peopleInfo.getPeople(Integer.parseInt(id));

        System.out.print("함자, 나이, 재산, 주소 중 수정할 항목 입력: ");
        String cmd = Container.getScanner().nextLine().trim();
        switch (cmd) {
            case "함자":
                String name = Container.getScanner().nextLine().trim();
                Pp.setName(name);
                break;
            case "나이":
                String age = Container.getScanner().nextLine().trim();
                Pp.setAge(Integer.parseInt(age));
                break;
            case "재산":
                String asset = Container.getScanner().nextLine().trim();
                Pp.setAsset(Integer.parseInt(asset));
                break;
            case "주소":
                String address = Container.getScanner().nextLine().trim();
                Pp.setAddress(address);
                break;
        }
        peopleInfo.UpdatePeople(Pp);

    }
}
