package by.step.aqa.g1822.finalProject.service.menuForAdmin;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.MenuForPodAdmin;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.addedCategory.MethodForAddedCategory;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.categoreSearch.MethodCategorySearch;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.deleteCategory.MethodDeleteCategory;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.summ.MethodForSumm;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.InputMismatchException;

public class MenuForAdmin {
    private ListForMenuForAdmin listForMenuForAdmin = new ListForMenuForAdmin();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();
    private MethodsWatch methodsWatch = new MethodsWatch();
    private MethodForSumm methodForSumm = new MethodForSumm();
    private MethodForAddedCategory methodForAddedCategory = new MethodForAddedCategory();
    private MethodDeleteCategory methodDeleteCategory = new MethodDeleteCategory();
    private MethodCategorySearch methodCategorySearch = new MethodCategorySearch();
    private boolean end = true;

    private void variousOfDoInMenu() {
        try{
        MenuForPodAdmin menuForPodAdmin = new MenuForPodAdmin();
        listForMenuForAdmin.getCreatedMenu();
        int number = scanner.getNumberOfVarious();
        switch (number) {
            case 1:
                methodsWatch.getWatchedCategoriesList();
                break;
            case 2:
                methodsWatch.getWatchedAllList();
                break;
            case 3:
                methodForSumm.getSummaInAllCategories();
                break;
            case 4:
                menuForPodAdmin.getVariousOfDoInPodMenu();
                break;
            case 5:
                methodForAddedCategory.getAddedNewCategory();
                break;
            case 6:
                methodDeleteCategory.getDeleteCategories();
                break;
            case 7:
                methodCategorySearch.getCategorySearch();
                break;
            case 8:
                System.out.println("Программа завершена!");
                System.exit(0);
                end = false;
        }
        }catch (InputMismatchException e){
            variousOfDoInMenu();
        }
    }

    public void cycleForMenu() {
        MenuForAdmin menuForAdmin = new MenuForAdmin();
        do {
            menuForAdmin.variousOfDoInMenu();
        } while (menuForAdmin.end);
    }

    public void getVariousOfDoInMenu(){
        variousOfDoInMenu();
    }
}
