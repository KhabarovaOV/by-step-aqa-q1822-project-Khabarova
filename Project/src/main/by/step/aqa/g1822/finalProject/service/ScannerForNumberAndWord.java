package by.step.aqa.g1822.finalProject.service;

import java.util.Scanner;

public class ScannerForNumberAndWord {
    private int scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String scanTwo(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public int getNumberOfVarious() {
        return scan();
    }
    public String getWord(){return scanTwo();}
}

