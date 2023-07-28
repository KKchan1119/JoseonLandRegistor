package com.lr.controller;
import java.util.Scanner;
public class input {
    public static Scanner scanner = new Scanner(System.in);
    public static int nextInt(){
        if(scanner.hasNext()) {
            return scanner.nextInt();
        }else {
            return 0;
        }
    }

    public static String nextString(){
        if(scanner.hasNext()) {
            return scanner.nextLine();
        }else {
            return "";
        }
    }

}
