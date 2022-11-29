package by.step.aqa.g1822.finalProject.service.methodsForMenu.addedCategory;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.List;

public class MethodForAddedCategory {
    private MethodsWatch methodsWatch = new MethodsWatch();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();

    private List<String> addedNewCategory() {
        CreatedCollection createdCollection = new CreatedCollection();
        List<String> readBase = createdCollection.readFile();
        methodsWatch.getChoosingToViewListOfCategories();
        System.out.println("Номер категории, которую вы добавляете: " + readBase.size());
        System.out.println("Введите новую категорию согласно примеру(номер категории, название в кавычках, значение рассходов через запятую(Все через запятую и без пробелов)): ");
        String newCategories = scanner.getWord();
        readBase.add(newCategories);
        createdCollection.writeFile();
        return readBase;
    }

    public void getAddedNewCategory() {
        addedNewCategory();
    }
}
