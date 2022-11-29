package by.step.aqa.g1822.finalProject.service.menuForUser.podMenuForUser;

import java.util.HashMap;

public class ListForPodMenuForUser {
    private HashMap<Integer, String> NumberOfVariousPodMenu = new HashMap<>();

    private void createdPodMenu() {
        System.out.println("Выберете пункт из подменю: ");
        NumberOfVariousPodMenu.put(1, " Посмотреть список всех категорий");
        NumberOfVariousPodMenu.put(2, " Посмотреть все рассходы в данной категории");
        NumberOfVariousPodMenu.put(3, " Сумма всех рассходов в данной категории");
        NumberOfVariousPodMenu.put(4, " Добавить новый рассход в данной категории");
        NumberOfVariousPodMenu.put(5, " Удалить последний рассход в данной категории");
        NumberOfVariousPodMenu.put(6, " Выход из подменю в главное меню");
        System.out.println(NumberOfVariousPodMenu);
    }

    public void getCreatedPodMenu(){
        createdPodMenu();
    }
}
