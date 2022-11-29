package by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.methodsForPodMenu.changeExpense;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.MenuForPodAdmin;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.List;
import java.util.Scanner;

public class MethodChangeExpense {
    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    private MethodsWatch methodsWatch = new MethodsWatch();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();
    private List<String> changeSpecificExpense() {
        MenuForPodAdmin menuForPodAdmin = new MenuForPodAdmin();
        try {
            methodsWatch.getChoosingToViewListOfCategories();
            System.out.println("Введите номер категории в которой, хотите изменить рассход: ");
            int l = scanner.getNumberOfVarious();
            String s = readBase.get(l);
            System.out.println(s);
            System.out.println("Введите номер рассхода который хотите заменить: ");
            int num = scanner.getNumberOfVarious();
            System.out.println("Введите номер значение нового рассхода: ");
            Scanner scanner = new Scanner(System.in);
            String num2 = scanner.nextLine();
            String[] arr = s.split(",");
            int num3 = num + 1;
            arr[num3] = num2;
            String newLineInList = "";
            for (int i = 0; i < arr.length; i++) {
                newLineInList += arr[i];
                if (i != arr.length - 1) {
                    newLineInList += ",";
                }
            }
            readBase.set(l, newLineInList);
            createdCollection.writeFile();
            menuForPodAdmin.getVariousOfDoInPodMenu();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное число");
            changeSpecificExpense();
        }
        return readBase;
    }

    public void getChangeSpecificExpense(){
        changeSpecificExpense();
    }
}
