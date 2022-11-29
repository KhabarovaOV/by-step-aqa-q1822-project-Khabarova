package by.step.aqa.g1822.finalProject.service.menuForUser.podMenuForUser.methodsForPodMenu.deleteExpense;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.MenuForPodAdmin;
import by.step.aqa.g1822.finalProject.service.menuForUser.podMenuForUser.MenuForPodMenuForUser;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.ArrayList;
import java.util.List;

public class MethodDeleteExpense {
    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    MethodsWatch methodsWatch = new MethodsWatch();
    ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();

    private List<String> deleteLastAddedExpenseInOneCategories() {
        MenuForPodMenuForUser menuForPodMenuForUser = new MenuForPodMenuForUser();
        try {
            methodsWatch.getChoosingToViewListOfCategories();
            System.out.println("Введите номер категории которую хотите выбрать: ");
            int l = scanner.getNumberOfVarious();
            String s = readBase.get(l);
            System.out.println(s);
            String[] arr = s.split(",");
            String[] arr2 = new String[arr.length - 1];
            try {
                System.arraycopy(arr, 0, arr2, 0, arr.length - 1);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException es) {
            }

            String newLineInList = "";
            for (int k = 0; k < arr2.length; k++) {
                newLineInList += arr2[k];
                if (k != arr2.length - 1) {
                    newLineInList += ",";
                }
            }
            readBase.set(l, newLineInList);
            createdCollection.writeFile();
            menuForPodMenuForUser.getVariousOfDoInPodMenu();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное число");
            deleteLastAddedExpenseInOneCategories();
        }
        return readBase;
    }

    public void getDeleteLastAddedExpenseInOneCategories(){
        deleteLastAddedExpenseInOneCategories();
    }

}
