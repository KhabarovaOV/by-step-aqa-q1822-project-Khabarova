package by.step.aqa.g1822.finalProject.service.menuForUser.podMenuForUser;

import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForUser.MenuForUser;
import by.step.aqa.g1822.finalProject.service.methodsForPodMenu.addedExpense.MethodAddedExpense;
import by.step.aqa.g1822.finalProject.service.methodsForPodMenu.deleteExpense.MethodsDeleteExpense;
import by.step.aqa.g1822.finalProject.service.methodsForPodMenu.summ.MethodSummForPodMenu;
import by.step.aqa.g1822.finalProject.service.methodsForPodMenu.watch.MethodsWatchForPodMenu;

import java.util.InputMismatchException;

public class MenuForPodMenuForUser {
    private boolean exid = true;
    ListForPodMenuForUser listForPodMenuForUser = new ListForPodMenuForUser();
    ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();
    MethodsWatchForPodMenu methodsWatchForPodMenu = new MethodsWatchForPodMenu();
    MethodSummForPodMenu methodSummForPodMenu = new MethodSummForPodMenu();
    MethodAddedExpense methodAddedExpense = new MethodAddedExpense();
    MethodsDeleteExpense methodDeleteExpense = new MethodsDeleteExpense();

    private void variousOfDoInPodMenu() {
        try {
            MenuForUser menuForUser = new MenuForUser();
            listForPodMenuForUser.getCreatedPodMenu();
            int menuPoint = scanner.getNumberOfVarious();
            switch (menuPoint) {
                case 1:
                    methodsWatchForPodMenu.getWatchedCategoriesListInPodMenu();
                    break;
                case 2:
                    methodsWatchForPodMenu.getWatchedOneCategories();
                    break;
                case 3:
                    methodSummForPodMenu.getSummaInOneCategories();
                    break;
                case 4:
                    methodAddedExpense.getAddNewExpenseInOneCategories();
                    break;
                case 5:
                    methodDeleteExpense.getDeleteLastAddedExpenseInOneCategories();
                    break;
                case 6:
                    exid = false;
                    menuForUser.getVariousOfDoInMenu();
                    break;
            }
        } catch (InputMismatchException e) {
            variousOfDoInPodMenu();
        }
    }

    public void cycleForPodMenu() {
        MenuForPodMenuForUser menuForPodMenuForUser = new MenuForPodMenuForUser();
        do {
            menuForPodMenuForUser.variousOfDoInPodMenu();
        } while (menuForPodMenuForUser.exid);
    }

    public void getVariousOfDoInPodMenu() {
        variousOfDoInPodMenu();
    }
}
