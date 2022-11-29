package by.step.aqa.g1822.finalProject.service.menuForUser.podMenuForUser.methodsForPodMenu.summ;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.MenuForPodAdmin;
import by.step.aqa.g1822.finalProject.service.menuForUser.podMenuForUser.MenuForPodMenuForUser;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.List;

public class MethodSummForPodMenu {

    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    MethodsWatch methodsWatch = new MethodsWatch();
    ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();
    private void summaInOneCategories() {
        MenuForPodMenuForUser menuForPodMenuForUser = new MenuForPodMenuForUser();
        try {
            methodsWatch.getChoosingToViewListOfCategories();
            System.out.println("Введите номер категории которую хотите выбрать: ");
            int l = scanner.getNumberOfVarious();
            String s = readBase.get(l);
            System.out.println(s);
            String[] arr = s.split(",");
            String[] arr2 = new String[arr.length - 2];
            System.arraycopy(arr, 2, arr2, 0, arr.length - 2);
            double[] arr3 = new double[arr2.length];
            int index = 0;
            double x = 0;
            for (int i = 0; i < arr2.length; i++) {
                try {
                    arr3[index] = Double.parseDouble(arr2[i]);
                    index++;
                } catch (NumberFormatException es) {
                }
            }
            for (int j = 0; j < arr3.length; j++) {
                x += arr3[j];
            }
            System.out.println(x);
            menuForPodMenuForUser.getVariousOfDoInPodMenu();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное число");
            summaInOneCategories();
        }
    }

    public void getSummaInOneCategories(){
        summaInOneCategories();
    }
}
