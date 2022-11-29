package by.step.aqa.g1822.finalProject.service.menuForAdmin;
import java.util.HashMap;

public class ListForMenuForAdmin {
     private HashMap<Integer, String> NumberOfVarious = new HashMap<>();
     private void createdMenu() {
        System.out.println("Выберете пункт из меню: ");
        NumberOfVarious.put(1, " Посмотреть список всех категорий");
        NumberOfVarious.put(2, " Посмотреть все расходы");
        NumberOfVarious.put(3, " Посмотреть сумму всех расходов");
        NumberOfVarious.put(4, " Выберете категорию расходов, который хотите посмотреть подробнее");
        NumberOfVarious.put(5, " Добавить новую категорию");
        NumberOfVarious.put(6, " Удалить выбранную категорию");
        NumberOfVarious.put(7, " Поиск категории по имени");
        NumberOfVarious.put(8, "Выход");
        System.out.println(NumberOfVarious);
    }

    public void getCreatedMenu(){
         createdMenu();
    }
}
