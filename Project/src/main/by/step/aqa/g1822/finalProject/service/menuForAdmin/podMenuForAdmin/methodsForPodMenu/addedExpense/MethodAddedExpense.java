package by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.methodsForPodMenu.addedExpense;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.MenuForPodAdmin;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.List;
import java.util.Scanner;

public class MethodAddedExpense {
    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    private MethodsWatch methodsWatch = new MethodsWatch();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();
    private List<String> addNewExpenseInOneCategories() {
        MenuForPodAdmin menuForPodAdmin = new MenuForPodAdmin();
        methodsWatch.getChoosingToViewListOfCategories();
        System.out.println("Введите номер категории которую хотите выбрать: ");
        int l = scanner.getNumberOfVarious();
        try {
            String s = readBase.get(l);
            System.out.println(s);
            String[] arr = s.split(",");
            String[] arr2 = new String[arr.length + 1];
            int index = 0;
            for (int i = 0; i < arr2.length; i++) {
                try {
                    arr2[index] = arr[i];
                    index++;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException es) {
                }
            }
            System.out.println("Ведите новый расход в данной категории: ");
            Scanner sc = new Scanner(System.in);
            String newExpense = sc.nextLine();
            try {
                Double.parseDouble(newExpense);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число, повторите ввод.");
                sc.nextLine();
            }
            arr2[arr2.length - 1] = newExpense;
            String newLineInList = "";
            for (int k = 0; k < arr2.length; k++) {
                newLineInList += arr2[k];
                if (k != arr2.length - 1) {
                    newLineInList += ",";
                }
            }
            readBase.set(l, newLineInList);
            createdCollection.writeFile();
            menuForPodAdmin.getVariousOfDoInPodMenu();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное число.");
            addNewExpenseInOneCategories();
        }
        return readBase;
    }

    public void getAddNewExpenseInOneCategories(){
        addNewExpenseInOneCategories();
    }
}
