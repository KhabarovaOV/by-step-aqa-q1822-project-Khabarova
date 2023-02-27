package by.step.aqa.g1822.finalProject.service.menuForUser;

import java.util.HashMap;

public class ListForMenuForUser {
    private HashMap<Integer, String> NumberOfVarious = new HashMap<>();

    private void createdMenu() {
        System.out.println("Выберете пункт из меню: ");
        NumberOfVarious.put(1, " Посмотреть список всех категорий");
        NumberOfVarious.put(2, " Посмотреть все расходы");
        NumberOfVarious.put(3, " Поиск категории по имени");
        NumberOfVarious.put(4, " Выберете категорию расходов, который хотите посмотреть подробнее");
        NumberOfVarious.put(5, " Выход");
        System.out.println(NumberOfVarious);
    }

    public void getCreatedMenu() {
        createdMenu();
    }
}
