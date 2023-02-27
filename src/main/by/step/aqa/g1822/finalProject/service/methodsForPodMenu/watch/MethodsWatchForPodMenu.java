package by.step.aqa.g1822.finalProject.service.methodsForPodMenu.watch;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;
import by.step.aqa.g1822.finalProject.service.menuForAdmin.podMenuForAdmin.MenuForPodAdmin;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.List;

public class MethodsWatchForPodMenu {
    private MethodsWatch methodsWatch = new MethodsWatch();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();

    private void watchedCategoriesListInPodMenu() {
        CreatedCollection createdCollection = new CreatedCollection();
        List<String> readBase = createdCollection.readFile();
        System.out.println("Список категорий: ");
        for (String s : readBase
        ) {
            String[] array = s.split(",");
            System.out.println(array[0] + ". " + array[1]);
        }
        System.out.println();
    }

    private void watchedOneCategories() {
        CreatedCollection createdCollection = new CreatedCollection();
        List<String> readBase = createdCollection.readFile();
        try {
            methodsWatch.getChoosingToViewListOfCategories();
            System.out.println("Введите номер категории которую хотите выбрать: ");
            int l = scanner.getNumberOfVarious();
            String m = readBase.get(l);
            System.out.println(m);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное число");
            watchedOneCategories();
        }
    }

    public void getWatchedOneCategories() {
        watchedOneCategories();
    }

    public void getWatchedCategoriesListInPodMenu() {
        watchedCategoriesListInPodMenu();
    }
}
