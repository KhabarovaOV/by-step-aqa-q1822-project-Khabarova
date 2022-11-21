import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class AdminMenu extends CreatedCollection {
    private boolean end = true;
    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    HashMap<Integer, String> NumberOfVarious = new HashMap<>();
    HashMap<Integer, String> NumberOfVariousPodMenu = new HashMap<>();

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

    private void createdPodMenu() {
        System.out.println("Выберете пункт из подменю: ");
        NumberOfVariousPodMenu.put(1, " Посмотреть список всех категорий");
        NumberOfVariousPodMenu.put(2, " Посмотреть все рассходы в данной категории");
        NumberOfVariousPodMenu.put(3, " Сумма всех рассходов в данной категории");
        NumberOfVariousPodMenu.put(4, " Добавить новый рассход в данной категории");
        NumberOfVariousPodMenu.put(5, " Удалить последний рассход в данной категории");
        NumberOfVariousPodMenu.put(6, " Удалить выбранный рассход в данной категории");
        NumberOfVariousPodMenu.put(7, " Заменить значение рассхода в данной категории");
        NumberOfVariousPodMenu.put(8, " Выход из подменю в главное меню");
        System.out.println(NumberOfVariousPodMenu);
    }

    private int scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int getNumberOfVarious() {
        return scan();
    }

    private void variousOfDoInMenu() {
        createdMenu();
        int number = getNumberOfVarious();
        switch (number) {
            case 1:
                watchedCategoriesList();
                break;
            case 2:
                watchedAllList();
                break;
            case 3:
                summaInAllCategories();
                break;
            case 4:
                variousOfDoInPodMenu();
                break;
            case 5:
                addedNewCategory();
                break;
            case 6:
                deleteCategories();
                break;
            case 7:
                categorySearch();
                break;
            case 8:
                System.out.println("Программа завершена!");
                end = false;
        }
    }

    private void variousOfDoInPodMenu() {
        createdPodMenu();
        int menuPoint = getNumberOfVarious();
        switch (menuPoint) {
            case 1:
                watchedCategoriesListInPodMenu();
                break;
            case 2:
                watchedOneCategories();
                break;
            case 3:
                summaInOneCategories();
                break;
            case 4:
                addNewExpenseInOneCategories();
                break;
            case 5:
                deleteLastAddedExpenseInOneCategories();
                break;
            case 6:
                deleteTheSelectedExpense();
                break;
            case 7:
                changeSpecificExpense();
                break;
            case 8:
                variousOfDoInMenu();
                break;
        }

    }

    private void watchedCategoriesList() {
        System.out.println("Список категорий: ");
        for (String s : readBase
        ) {
            String[] array = s.split(",");
            System.out.println(array[0] + ". " + array[1]);
        }
        System.out.println();
    }

    private void watchedCategoriesListInPodMenu() {
        System.out.println("Список категорий: ");
        for (String s : readBase
        ) {
            String[] array = s.split(",");
            System.out.println(array[0] + ". " + array[1]);
        }
        System.out.println();
        variousOfDoInPodMenu();
    }

    private void watchedAllList() {
        readFile();
        for (String str : readBase) {
            System.out.println(str);
        }
    }

    private double summaInAllCategories() {
        choosingToViewListOfCategories();
        double x = 0;
        for (int i = 0; i < readBase.size(); i++) {
            String str1 = readBase.get(i);
            String[] arr = str1.split(",");
            String[] arr2 = new String[arr.length - 2];
            System.arraycopy(arr, 2, arr2, 0, arr.length - 2);
            double[] arr3 = new double[arr2.length];
            int index = 0;
            for (int j = 0; j < arr2.length; j++) {
                try {
                    arr3[index] = Double.parseDouble(arr2[j]);
                    index++;
                } catch (NumberFormatException es) {
                }
            }
            for (int n = 0; n < arr3.length; n++) {
                x += arr3[n];
            }
        }
        System.out.println(x);
        return x;
    }

    private List<String> addedNewCategory() {
        choosingToViewListOfCategories();
        System.out.println("Номер категории, которую вы добавляете: " + readBase.size());
        System.out.println("Введите новую категорию согласно примеру(номер категории, название в кавычках, значение рассходов через запятую(Все через запятую и без пробелов)): ");
        Scanner text = new Scanner(System.in);
        String newCategories = text.nextLine();
        readBase.add(newCategories);
        writeFile();
        return readBase;
    }

    private List<String> deleteCategories() {
        try{
        choosingToViewListOfCategories();
        System.out.println("Введите номер категории которую хотите удалить: ");
        Scanner num = new Scanner(System.in);
        int l = num.nextInt();
        readBase.remove(l);
        writeFile();
        sortingCategoriesAfterDeletion();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы ввели неверное число");
            deleteCategories();
        }
        return readBase;
    }

    private List<String> categorySearch(){
        System.out.println("Введите имя категории, которую хотите найти с большой буквы: ");
        Scanner scan = new Scanner(System.in);
        String search = scan.nextLine();
        int i = 0;
        for (String str: readBase) {
            if (str.contains(search)){
                System.out.println(str);
            }else if(i == 0) {
                System.out.println("Категория не найдена.");
            }
            i++;
        }
        return readBase;
    }

    private void sortingCategoriesAfterDeletion(){
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
        writeFile();
    }
    private void choosingToViewListOfCategories() {
        System.out.println("Хотите посмотреть список категорий ещё раз?(Да или Нет)");
        String answerYes = "Да";
        String answerNo = "Нет";
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();

        if (answer.equals(answerYes)) {
            watchedCategoriesList();
        } else if (answer.equals(answerNo)) {
            System.out.println("Ок, продолжаем.");
        } else {
            System.out.println("Вы ввели не ответ!");
            choosingToViewListOfCategories();
        }
    }

    private void watchedOneCategories() {
        try{
        choosingToViewListOfCategories();
        System.out.println("Введите номер категории которую хотите выбрать: ");
        int l = getNumberOfVarious();
        String m = readBase.get(l);
        System.out.println(m);
        variousOfDoInPodMenu();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы ввели неверное число");
            watchedOneCategories();
        }
    }

    private void summaInOneCategories() {
        try {
            choosingToViewListOfCategories();
            System.out.println("Введите номер категории которую хотите выбрать: ");
            int l = getNumberOfVarious();
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
            variousOfDoInPodMenu();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы ввели неверное число");
            summaInOneCategories();
        }
    }

    private List<String> addNewExpenseInOneCategories() {
        try{
        choosingToViewListOfCategories();
        System.out.println("Введите номер категории которую хотите выбрать: ");
        int l = getNumberOfVarious();
        String s = readBase.get(l);
        System.out.println(s);
        String[] arr = s.split(",");
        String[] arr2 = new String[arr.length + 1];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            try {
                arr2[index] = arr[i];
                index++;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException es) {
            }
        }
        System.out.println("Ведите новый расход в данной категории: ");
        Scanner sc = new Scanner(System.in);
        String newExpense = sc.nextLine();
        arr2[arr2.length - 1] = newExpense;
        String newLineInList = "";
        for (int k = 0; k < arr2.length; k++) {
            newLineInList += arr2[k];
            if (k != arr2.length - 1) {
                newLineInList += ",";
            }
        }
        readBase.set(l, newLineInList);
        writeFile();
        variousOfDoInPodMenu();
    }catch (IndexOutOfBoundsException e){
            System.out.println("Вы ввели неверное число");
            addNewExpenseInOneCategories();
        }
        return readBase;
    }

    private List<String> deleteLastAddedExpenseInOneCategories() {
        try {
            choosingToViewListOfCategories();
            System.out.println("Введите номер категории которую хотите выбрать: ");
            int l = getNumberOfVarious();
            String s = readBase.get(l);
            System.out.println(s);

            String[] arr = s.split(",");
            String[] arr2 = new String[arr.length - 1];
            try {
                System.arraycopy(arr, 0, arr2, 0, arr.length - 1);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException es) {
            }

            String newLineInList = "";
            for (int k = 0; k < arr2.length; k++) {
                newLineInList += arr2[k];
                if (k != arr2.length - 1) {
                    newLineInList += ",";
                }
            }
            readBase.set(l, newLineInList);
            writeFile();
            variousOfDoInPodMenu();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы ввели неверное число");
            deleteLastAddedExpenseInOneCategories();
        }
        return readBase;
    }

    private List<String> deleteTheSelectedExpense(){
        try {
            choosingToViewListOfCategories();
            System.out.println("Введите номер категории в которой, хотите удалить рассход: ");
            int l = getNumberOfVarious();
            String s = readBase.get(l);
            System.out.println(s);
            System.out.println("Введите номер рассхода который хотите удалить: ");
            int num = getNumberOfVarious();
            int num2 = num + 1;
            String[] arr = s.split(",");
            arr[num2] = null;
            List<String> list = new ArrayList<>();
            for (String m : arr) {
                if (m != null && m.length() > 0) {
                    list.add(m);
                }
            }
            arr = list.toArray(new String[list.size()]);
            String newLineInList = "";
            for (int k = 0; k < arr.length; k++) {
                newLineInList += arr[k];
                if (k != arr.length - 1) {
                    newLineInList += ",";
                }
            }
            readBase.set(l, newLineInList);
            writeFile();
            variousOfDoInPodMenu();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы ввели неверное число");
            deleteTheSelectedExpense();
        }
        return readBase;
    }
    private List<String> changeSpecificExpense(){
        try {
            choosingToViewListOfCategories();
            System.out.println("Введите номер категории в которой, хотите изменить рассход: ");
            int l = getNumberOfVarious();
            String s = readBase.get(l);
            System.out.println(s);

            System.out.println("Введите номер рассхода который хотите заменить: ");
            int num = getNumberOfVarious();

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
            writeFile();
            variousOfDoInPodMenu();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы ввели неверное число");
            changeSpecificExpense();
        }
        return readBase;
    }

    private List writeFile() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Project\\src\\sources\\resources\\DataBase.txt"));
            for (String str1 : readBase
            ) {
                bufferedWriter.write(str1);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return readBase;
    }

    public void cycleForMenu() {
        AdminMenu adminMenu = new AdminMenu();
        do {
            adminMenu.variousOfDoInMenu();
        } while (adminMenu.end);
    }

}
