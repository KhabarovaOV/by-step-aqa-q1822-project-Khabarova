package by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.methodsForPodMenu.deleteExpense;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.MenuForPodAdmin;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.ArrayList;
import java.util.List;

public class MethodsDeleteExpense {
    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    private MethodsWatch methodsWatch = new MethodsWatch();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();

    private List<String> deleteLastAddedExpenseInOneCategories() {
        MenuForPodAdmin menuForPodAdmin = new MenuForPodAdmin();
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
            menuForPodAdmin.getVariousOfDoInPodMenu();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное число");
            deleteLastAddedExpenseInOneCategories();
        }
        return readBase;
    }

    private List<String> deleteTheSelectedExpense() {
        MenuForPodAdmin menuForPodAdmin = new MenuForPodAdmin();
        try {
            methodsWatch.getChoosingToViewListOfCategories();
            System.out.println("Введите номер категории в которой, хотите удалить рассход: ");
            int l = scanner.getNumberOfVarious();
            String s = readBase.get(l);
            System.out.println(s);
            System.out.println("Введите номер рассхода который хотите удалить: ");
            int num = scanner.getNumberOfVarious();
            int num2 = num + 1;
            String[] arr = s.split(",");
            arr[num2] = null;
            List<String> list = new ArrayList<>();
            for (String m : arr) {
                if (m != null && m.length() > 0) {
                    list.add(m);
                }
            }
            arr = list.toArray(new String[list.size()]);
            String newLineInList = "";
            for (int k = 0; k < arr.length; k++) {
                newLineInList += arr[k];
                if (k != arr.length - 1) {
                    newLineInList += ",";
                }
            }
            readBase.set(l, newLineInList);
            createdCollection.writeFile();
            menuForPodAdmin.getVariousOfDoInPodMenu();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное число");
            deleteTheSelectedExpense();
        }
        return readBase;
    }

    public void getDeleteLastAddedExpenseInOneCategories(){
        deleteLastAddedExpenseInOneCategories();
    }

    public void getDeleteTheSelectedExpense(){
        deleteTheSelectedExpense();
    }


}
