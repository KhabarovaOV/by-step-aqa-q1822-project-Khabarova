package by.step.aqa.g1822.finalProject.service.methodsForMenu.categoreSearch;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.ScannerForNumberAndWord;

import java.util.List;

public class MethodCategorySearch {
    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    private ScannerForNumberAndWord scanner = new ScannerForNumberAndWord();

    private List<String> categorySearch() {
        System.out.println("Введите имя категории, которую хотите найти с большой буквы: ");
        String search = scanner.getWord();
        int y = 0;
        for (String str : readBase) {
            if (str.contains(search)) {
                System.out.println(str);
            } else {
                y++;
                if (y == readBase.size()) {
                    System.out.println("Категория не найдена.");
                }
            }
        }
        return readBase;
    }

    public void getCategorySearch(){
        categorySearch();
    }
}
