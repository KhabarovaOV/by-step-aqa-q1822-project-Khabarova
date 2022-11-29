package by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin;

import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.MenuForAdmin;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.methodsForPodMenu.addedExpense.MethodAddedExpense;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.methodsForPodMenu.changeExpense.MethodChangeExpense;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.methodsForPodMenu.deleteExpense.MethodsDeleteExpense;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.methodsForPodMenu.summ.MethodSummForPodMenu;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.methodsForPodMenu.watch.MethodsWatchForPodMenu;

import java.util.InputMismatchException;

public class MenuForPodAdmin {
    private ListForPodMenuForAdmin listForPodMenuForAdmin = new ListForPodMenuForAdmin();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();
    private MenuForAdmin menuForAdmin = new MenuForAdmin();
    private MethodsWatchForPodMenu methodsWatch = new MethodsWatchForPodMenu();
    private MethodSummForPodMenu methodSummForPodMenu = new MethodSummForPodMenu();
    private MethodAddedExpense methodAddedExpense = new MethodAddedExpense();
    private MethodsDeleteExpense methodsDeleteExpense = new MethodsDeleteExpense();
    private MethodChangeExpense methodChangeExpense = new MethodChangeExpense();

    private void variousOfDoInPodMenu() {
        try {
            listForPodMenuForAdmin.getCreatedPodMenu();
            int menuPoint = scanner.getNumberOfVarious();
            switch (menuPoint) {
                case 1:
                    methodsWatch.getWatchedCategoriesListInPodMenu();
                    break;
                case 2:
                    methodsWatch.getWatchedOneCategories();
                    break;
                case 3:
                    methodSummForPodMenu.getSummaInOneCategories();
                    break;
                case 4:
                    methodAddedExpense.getAddNewExpenseInOneCategories();
                    break;
                case 5:
                    methodsDeleteExpense.getDeleteLastAddedExpenseInOneCategories();
                    break;
                case 6:
                    methodsDeleteExpense.getDeleteTheSelectedExpense();
                    break;
                case 7:
                    methodChangeExpense.getChangeSpecificExpense();
                    break;
                case 8:
                    menuForAdmin.getVariousOfDoInMenu();
                    break;
            }
        }catch (InputMismatchException e){
            variousOfDoInPodMenu();
        }
    }

    public void getVariousOfDoInPodMenu(){
        variousOfDoInPodMenu();
    }
}
