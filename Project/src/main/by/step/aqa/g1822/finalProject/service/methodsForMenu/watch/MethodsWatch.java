package by.step.aqa.g1822.finalProject.service.methodsForMenu.watch;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;

import java.util.List;

public class MethodsWatch {
    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();

    private void watchedCategoriesList() {
        System.out.println("Список категорий: ");
        for (String s : readBase
        ) {
            String[] array = s.split(",");
            System.out.println(array[0] + ". " + array[1]);
        }
        System.out.println();
    }

    private void watchedAllList() {
        for (String str : readBase) {
            System.out.println(str);
        }
    }

    private void choosingToViewListOfCategories() {
        System.out.println("Хотите посмотреть список категорий ещё раз?(Да или Нет)");
        String answerYes = "Да";
        String answerNo = "Нет";
        String answer = scanner.getWord();
        if (answer.equals(answerYes)) {
            watchedCategoriesList();
        } else if (answer.equals(answerNo)) {
            System.out.println("Ок, продолжаем.");
        } else {
            System.out.println("Вы ввели не ответ!");
            choosingToViewListOfCategories();
        }
    }

    public  void getWatchedCategoriesList(){
        watchedCategoriesList();
    }

    public void getWatchedAllList(){
        watchedAllList();
    }

    public void getChoosingToViewListOfCategories(){
        choosingToViewListOfCategories();
    }
}
