package by.step.aqa.g1822.finalProject.controller;

import java.util.Scanner;

public class TestPassword implements Menu {
    private final int passwordAdmin = 2525;

    private void testPassword() {
        AdminMenu adminMenu = new AdminMenu();
        UserMenu userMenu = new UserMenu();
        System.out.println("Enter password: ");
        Scanner scan = new Scanner(System.in);
        int password = scan.nextInt();
        if (passwordAdmin == password) {
            System.out.println("You admin");
            adminMenu.cycleForMenu();
        } else {
            System.out.println("You user");
            userMenu.cycleForMenu();
        }
    }

    public void startProgram() {
        testPassword();
    }

}
