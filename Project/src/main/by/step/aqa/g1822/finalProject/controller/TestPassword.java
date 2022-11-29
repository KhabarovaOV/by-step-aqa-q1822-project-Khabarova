package by.step.aqa.g1822.finalProject.controller;

import by.step.aqa.g1822.finalProject.service.menuForAdmin.MenuForAdmin;
import by.step.aqa.g1822.finalProject.service.menuForUser.MenuForUser;

import java.util.Scanner;

public class TestPassword implements Menu {
    private final int passwordAdmin = 2525;

    private void testPassword() {
        MenuForAdmin menuForAdmin = new MenuForAdmin();
        MenuForUser menuForUser = new MenuForUser();
        System.out.println("Enter password: ");
        Scanner scan = new Scanner(System.in);
        int password = scan.nextInt();
        if (passwordAdmin == password) {
            System.out.println("You admin");
            menuForAdmin.cycleForMenu();
        } else {
            System.out.println("You user");
            menuForUser.cycleForMenu();
        }
    }

    public void startProgram() {
        testPassword();
    }

}
