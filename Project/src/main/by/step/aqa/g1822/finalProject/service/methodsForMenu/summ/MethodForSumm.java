package by.step.aqa.g1822.finalProject.service.methodsForMenu.summ;

import by.step.aqa.g1822.finalProject.dao.CreatedCollection;
import by.step.aqa.g1822.finalProject.service.methodsForMenu.watch.MethodsWatch;

import java.util.List;

public class MethodForSumm {
    CreatedCollection createdCollection = new CreatedCollection();
    List<String> readBase = createdCollection.readFile();
    private MethodsWatch methodsWatch = new MethodsWatch();

    private double summaInAllCategories() {
        methodsWatch.getChoosingToViewListOfCategories();
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

    public void getSummaInAllCategories(){
        summaInAllCategories();
    }
}
