package by.step.aqa.g1822.finalProject.service.methodsForMenu.deleteCategory;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.List;

public class MethodDeleteCategory {
    private MethodsWatch methodsWatch = new MethodsWatch();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();

    private List<String> deleteCategories() {
        CreatedCollection createdCollection = new CreatedCollection();
        List<String> readBase = createdCollection.readFile();
        try {
            methodsWatch.getChoosingToViewListOfCategories();
            System.out.println("Введите номер категории которую хотите удалить: ");
            int l = scanner.getNumberOfVarious();
            readBase.remove(l);
            createdCollection.writeFile();
            String x = "";
            for (int i = 0; i < readBase.size(); i++) {
                String str1 = readBase.get(i);
                String[] arr = str1.split(",");
                arr[0] = String.valueOf(((readBase.size() + i) - readBase.size()));
                for (int n = 0; n < arr.length; n++) {
                    x += arr[n];
                    if (n != arr.length - 1) {
                        x += ",";
                    }
                }
                readBase.set(i, x);
                x = "";
            }
            System.out.println(x);
            createdCollection.writeFile();
            return readBase;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное число");
            deleteCategories();
        }
        return readBase;
    }

    public void getDeleteCategories() {
        deleteCategories();
    }
}
