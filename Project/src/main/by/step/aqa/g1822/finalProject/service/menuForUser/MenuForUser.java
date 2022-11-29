package by.step.aqa.g1822.finalProject.service.menuForUser;

import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForUser.podMenuForUser.MenuForPodMenuForUser;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.categoreSearch.MethodCategorySearch;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.InputMismatchException;

public class MenuForUser {
    private boolean exid = true;
    ListForMenuForUser listForMenuForUser = new ListForMenuForUser();
    ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();
    MethodsWatch methodsWatch = new MethodsWatch();
    MethodCategorySearch methodCategorySearch = new MethodCategorySearch();


    private void variousOfDoInMenu() {
        try{
        MenuForPodMenuForUser menuForPodMenuForUser = new MenuForPodMenuForUser();
        listForMenuForUser.getCreatedMenu();
        int number = scanner.getNumberOfVarious();
        switch (number) {
            case 1:
                methodsWatch.getWatchedCategoriesList();
                break;
            case 2:
                methodsWatch.getWatchedAllList();
                break;
            case 3:
                methodCategorySearch.getCategorySearch();
                break;
            case 4:
                menuForPodMenuForUser.getVariousOfDoInPodMenu();
                break;
            case 5:
                System.out.println("Программа завершена!");
                System.exit(0);
                exid = false;
        }
        }catch (InputMismatchException e){
            variousOfDoInMenu();
        }
    }

    public void cycleForMenu() {
        MenuForUser menuForUser = new MenuForUser();
        do {
            menuForUser.variousOfDoInMenu();
        } while (menuForUser.exid);
    }

    public void getVariousOfDoInMenu(){
        variousOfDoInMenu();
    }

}
